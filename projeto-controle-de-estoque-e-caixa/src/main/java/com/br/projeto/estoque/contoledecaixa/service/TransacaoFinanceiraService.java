package com.br.projeto.estoque.contoledecaixa.service;


import com.br.projeto.estoque.contoledecaixa.dto.TransacaoFinanceiraDTO;

import java.util.List;

public interface TransacaoFinanceiraService {
    List<TransacaoFinanceiraDTO> listarTransacoesFinanceiras();
    TransacaoFinanceiraDTO salvarTransacaoFinanceira(TransacaoFinanceiraDTO transacaoFinanceira);
    TransacaoFinanceiraDTO atualizarTransacaoFinanceira(Long id);
    TransacaoFinanceiraDTO buscarTransacaoFinanceiraPorId(Long id);
    void deletarTransacaoFinanceira(Long id);
}
