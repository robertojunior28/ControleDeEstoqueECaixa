package com.br.projeto.estoque.contoledecaixa.service;


import com.br.projeto.estoque.contoledecaixa.dto.FornecedorDTO;

import java.util.List;

public interface FornecedorService {
    List<FornecedorDTO> listarFornecedores();
    FornecedorDTO salvarFornecedor(FornecedorDTO fornecedor);
    FornecedorDTO atualizarFornecedor(Long id, FornecedorDTO fornecedorDTO);
    FornecedorDTO buscarFornecedorPorId(Long id);
    void deletarFornecedor(Long id);
}
