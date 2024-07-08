package com.br.projeto.estoque.contoledecaixa.service;


import com.br.projeto.estoque.contoledecaixa.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> listarClientes();
    ClienteDTO salvarCliente(ClienteDTO cliente);
    ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO);
    ClienteDTO buscarClientePorId(Long id);
    void deletarCliente(Long id);
}
