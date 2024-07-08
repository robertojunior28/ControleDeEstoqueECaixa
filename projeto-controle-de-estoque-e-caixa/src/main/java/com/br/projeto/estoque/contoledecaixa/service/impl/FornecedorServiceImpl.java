package com.br.projeto.estoque.contoledecaixa.service.impl;
import com.br.projeto.estoque.contoledecaixa.dto.CompraDTO;
import com.br.projeto.estoque.contoledecaixa.dto.FornecedorDTO;
import com.br.projeto.estoque.contoledecaixa.model.Compra;
import com.br.projeto.estoque.contoledecaixa.model.Fornecedor;
import com.br.projeto.estoque.contoledecaixa.repository.FornecedorRepository;
import com.br.projeto.estoque.contoledecaixa.service.FornecedorService;
import com.br.projeto.estoque.contoledecaixa.utils.AtualizarEntidades;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<FornecedorDTO> listarFornecedores() {
        List<Fornecedor> fornecedores = fornecedorRepository.findAll();
        return fornecedores.stream()
                .map(fornecedor -> modelMapper.map(fornecedor, FornecedorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public FornecedorDTO salvarFornecedor(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = modelMapper.map(fornecedorDTO, Fornecedor.class);
        fornecedor = fornecedorRepository.save(fornecedor);
        return modelMapper.map(fornecedor, FornecedorDTO.class);
    }

    @Override
    public FornecedorDTO atualizarFornecedor(Long id, FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedorExistente = fornecedorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Compra não encontrada com o ID: " + id));

        // Atualiza os dados da compra existente com os dados do compraDTO
        Fornecedor fornecedorValidado = AtualizarEntidades.atualizarFornecedor(fornecedorExistente, fornecedorDTO);

        // Salva a compra atualizada no banco de dados
        Fornecedor fornecedorAtualizado = fornecedorRepository.save(fornecedorValidado);

        // Retorna o CompraDTO correspondente à compra atualizada
        return modelMapper.map(fornecedorAtualizado, FornecedorDTO.class);
    }

    @Override
    public FornecedorDTO buscarFornecedorPorId(Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id).orElse(null);
        return modelMapper.map(fornecedor, FornecedorDTO.class);
    }

    @Override
    public void deletarFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }
}

