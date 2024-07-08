package com.br.projeto.estoque.contoledecaixa.service.impl;


import com.br.projeto.estoque.contoledecaixa.dto.ClienteDTO;
import com.br.projeto.estoque.contoledecaixa.dto.CompraDTO;
import com.br.projeto.estoque.contoledecaixa.dto.ProdutoDTO;
import com.br.projeto.estoque.contoledecaixa.model.Cliente;
import com.br.projeto.estoque.contoledecaixa.model.Compra;
import com.br.projeto.estoque.contoledecaixa.model.Produto;
import com.br.projeto.estoque.contoledecaixa.repository.CompraRepository;
import com.br.projeto.estoque.contoledecaixa.service.CompraService;
import com.br.projeto.estoque.contoledecaixa.utils.AtualizarEntidades;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CompraDTO> listarCompras() {
        List<Compra> compras = compraRepository.findAll();
        return compras.stream()
                .map(compra -> modelMapper.map(compra, CompraDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CompraDTO salvarCompra(CompraDTO compraDTO) {
        Compra compra = modelMapper.map(compraDTO, Compra.class);
        compra = compraRepository.save(compra);
        return modelMapper.map(compra, CompraDTO.class);
    }

    @Override
    public CompraDTO atualizarCompra(Long id, CompraDTO compraDTO) {
        Compra compraExistente = compraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Compra não encontrada com o ID: " + id));

        // Atualiza os dados da compra existente com os dados do compraDTO
        Compra compraValidada = AtualizarEntidades.atualizarCompra(compraExistente, compraDTO);

        // Salva a compra atualizada no banco de dados
        Compra compraAtualizada = compraRepository.save(compraValidada);

        // Retorna o CompraDTO correspondente à compra atualizada
        return modelMapper.map(compraAtualizada, CompraDTO.class);
    }

    @Override
    public CompraDTO buscarCompraPorId(Long id) {
        Compra compra = compraRepository.findById(id).orElse(null);
        return modelMapper.map(compra, CompraDTO.class);
    }

    @Override
    public void deletarCompra(Long id) {
        compraRepository.deleteById(id);
    }
}

