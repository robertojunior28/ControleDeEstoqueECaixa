package com.br.projeto.estoque.contoledecaixa.service.impl;

import com.br.projeto.estoque.contoledecaixa.dto.TransacaoFinanceiraDTO;
import com.br.projeto.estoque.contoledecaixa.model.TransacaoFinanceira;
import com.br.projeto.estoque.contoledecaixa.repository.TransacaoFinanceiraRepository;
import com.br.projeto.estoque.contoledecaixa.service.TransacaoFinanceiraService;
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
    public TransacaoFinanceiraDTO atualizarTransacaoFinanceira(Long id) {
        return null;
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
