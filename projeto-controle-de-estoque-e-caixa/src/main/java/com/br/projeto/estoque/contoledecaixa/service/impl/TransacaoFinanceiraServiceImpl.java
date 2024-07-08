package com.br.projeto.estoque.contoledecaixa.service.impl;

import com.br.projeto.estoque.contoledecaixa.dto.ProdutoDTO;
import com.br.projeto.estoque.contoledecaixa.dto.TransacaoFinanceiraDTO;
import com.br.projeto.estoque.contoledecaixa.model.Produto;
import com.br.projeto.estoque.contoledecaixa.model.TransacaoFinanceira;
import com.br.projeto.estoque.contoledecaixa.repository.TransacaoFinanceiraRepository;
import com.br.projeto.estoque.contoledecaixa.service.TransacaoFinanceiraService;
import com.br.projeto.estoque.contoledecaixa.utils.AtualizarEntidades;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoFinanceiraServiceImpl implements TransacaoFinanceiraService {

    @Autowired
    private TransacaoFinanceiraRepository transacaoFinanceiraRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TransacaoFinanceiraDTO> listarTransacoesFinanceiras() {
        List<TransacaoFinanceira> transacoesFinanceiras = transacaoFinanceiraRepository.findAll();
        return transacoesFinanceiras.stream()
                .map(transacao -> modelMapper.map(transacao, TransacaoFinanceiraDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TransacaoFinanceiraDTO salvarTransacaoFinanceira(TransacaoFinanceiraDTO transacaoFinanceiraDTO) {
        TransacaoFinanceira transacaoFinanceira = modelMapper.map(transacaoFinanceiraDTO, TransacaoFinanceira.class);
        transacaoFinanceira = transacaoFinanceiraRepository.save(transacaoFinanceira);
        return modelMapper.map(transacaoFinanceira, TransacaoFinanceiraDTO.class);
    }

    @Override
    public TransacaoFinanceiraDTO atualizarTransacaoFinanceira(Long id, TransacaoFinanceiraDTO transacaoFinanceiraDTO) {
        TransacaoFinanceira transacaExistente = transacaoFinanceiraRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Compra não encontrada com o ID: " + id));

        // Atualiza os dados da compra existente com os dados do compraDTO
        TransacaoFinanceira transacaoValidada = AtualizarEntidades.atualizarTransacaoFinaceira(transacaExistente, transacaoFinanceiraDTO);

        // Salva a compra atualizada no banco de dados
        TransacaoFinanceira transacaoAtualizada = transacaoFinanceiraRepository.save(transacaoValidada);

        // Retorna o CompraDTO correspondente à compra atualizada
        return modelMapper.map(transacaoAtualizada, TransacaoFinanceiraDTO.class);
    }

    @Override
    public TransacaoFinanceiraDTO buscarTransacaoFinanceiraPorId(Long id) {
        TransacaoFinanceira transacaoFinanceira = transacaoFinanceiraRepository.findById(id).orElse(null);
        return modelMapper.map(transacaoFinanceira, TransacaoFinanceiraDTO.class);
    }

    @Override
    public void deletarTransacaoFinanceira(Long id) {
        transacaoFinanceiraRepository.deleteById(id);
    }
}
