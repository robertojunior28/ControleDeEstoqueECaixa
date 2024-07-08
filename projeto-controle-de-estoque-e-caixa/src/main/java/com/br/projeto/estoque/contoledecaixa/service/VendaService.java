package com.br.projeto.estoque.contoledecaixa.service;

import com.br.projeto.estoque.contoledecaixa.dto.VendaDTO;

import java.util.List;

public interface VendaService {
    List<VendaDTO> listarVendas();
    VendaDTO salvarVenda(VendaDTO venda);
    VendaDTO atualizarVenda(Long id);
    VendaDTO buscarVendaPorId(Long id);
    void deletarVenda(Long id);
}