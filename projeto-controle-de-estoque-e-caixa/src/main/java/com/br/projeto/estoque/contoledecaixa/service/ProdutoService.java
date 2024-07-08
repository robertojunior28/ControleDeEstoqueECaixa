package com.br.projeto.estoque.contoledecaixa.service;


import com.br.projeto.estoque.contoledecaixa.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoService {
    List<ProdutoDTO> listarProdutos();
    ProdutoDTO salvarProduto(ProdutoDTO produto);
    ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO);
    ProdutoDTO buscarProdutoPorId(Long id);
    void deletarProduto(Long id);
}
