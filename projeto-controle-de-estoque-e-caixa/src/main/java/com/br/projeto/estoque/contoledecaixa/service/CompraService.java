package com.br.projeto.estoque.contoledecaixa.service;

import com.br.projeto.estoque.contoledecaixa.dto.CompraDTO;

import java.util.List;

public interface CompraService {
    List<CompraDTO> listarCompras();
    CompraDTO salvarCompra(CompraDTO compra);
    CompraDTO atualizarCompra(Long id, CompraDTO compra);
    CompraDTO buscarCompraPorId(Long id);
    void deletarCompra(Long id);
}
