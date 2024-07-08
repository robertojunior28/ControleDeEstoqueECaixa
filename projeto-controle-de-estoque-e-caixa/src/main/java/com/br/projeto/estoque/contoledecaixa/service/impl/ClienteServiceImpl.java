package com.br.projeto.estoque.contoledecaixa.service.impl;
import com.br.projeto.estoque.contoledecaixa.dto.ClienteDTO;
import com.br.projeto.estoque.contoledecaixa.model.Cliente;
import com.br.projeto.estoque.contoledecaixa.repository.ClienteRepository;
import com.br.projeto.estoque.contoledecaixa.service.ClienteService;
import com.br.projeto.estoque.contoledecaixa.utils.AtualizarEntidades;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(cliente -> mapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO salvarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = mapper.map(clienteDTO, Cliente.class);
        cliente = clienteRepository.save(cliente);
        return mapper.map(cliente, ClienteDTO.class);
    }

    @Override
    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com o ID: " + id));

        // Atualiza os dados do cliente existente com os dados do clienteDTO
        Cliente clienteAtualizado = AtualizarEntidades.atualizarCliente(clienteExistente, clienteDTO);

        // Salva o cliente atualizado no banco de dados
        clienteAtualizado = clienteRepository.save(clienteExistente);

        // Retorna o ClienteDTO correspondente ao cliente atualizado
        return mapper.map(clienteAtualizado, ClienteDTO.class);
    }

    @Override
    public ClienteDTO buscarClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return mapper.map(cliente, ClienteDTO.class);
    }

    @Override
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}