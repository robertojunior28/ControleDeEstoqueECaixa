package com.br.projeto.estoque.contoledecaixa.service;


import com.br.projeto.estoque.contoledecaixa.dto.MovimentacaoEstoqueDTO;

import java.util.List;

public interface MovimentacaoEstoqueService {
    List<MovimentacaoEstoqueDTO> listarMovimentacoesEstoque();
    MovimentacaoEstoqueDTO salvarMovimentacaoEstoque(MovimentacaoEstoqueDTO movimentacaoEstoque);
    MovimentacaoEstoqueDTO atualizarMovimentacaoEstoque(Long id);
    MovimentacaoEstoqueDTO buscarMovimentacaoEstoquePorId(Long id);
    void deletarMovimentacaoEstoque(Long id);
}
