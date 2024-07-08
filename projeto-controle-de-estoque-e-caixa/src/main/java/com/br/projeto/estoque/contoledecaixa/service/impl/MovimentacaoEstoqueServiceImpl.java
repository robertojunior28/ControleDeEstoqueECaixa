package com.br.projeto.estoque.contoledecaixa.service.impl;
import com.br.projeto.estoque.contoledecaixa.dto.MovimentacaoEstoqueDTO;
import com.br.projeto.estoque.contoledecaixa.model.MovimentacaoEstoque;
import com.br.projeto.estoque.contoledecaixa.repository.MovimentacaoEstoqueRepository;
import com.br.projeto.estoque.contoledecaixa.service.MovimentacaoEstoqueService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovimentacaoEstoqueServiceImpl implements MovimentacaoEstoqueService {

    @Autowired
    private MovimentacaoEstoqueRepository movimentacaoEstoqueRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MovimentacaoEstoqueDTO> listarMovimentacoesEstoque() {
        List<MovimentacaoEstoque> movimentacoesEstoque = movimentacaoEstoqueRepository.findAll();
        return movimentacoesEstoque.stream()
                .map(movimentacao -> modelMapper.map(movimentacao, MovimentacaoEstoqueDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MovimentacaoEstoqueDTO salvarMovimentacaoEstoque(MovimentacaoEstoqueDTO movimentacaoEstoqueDTO) {
        MovimentacaoEstoque movimentacaoEstoque = modelMapper.map(movimentacaoEstoqueDTO, MovimentacaoEstoque.class);
        movimentacaoEstoque = movimentacaoEstoqueRepository.save(movimentacaoEstoque);
        return modelMapper.map(movimentacaoEstoque, MovimentacaoEstoqueDTO.class);
    }

    @Override
    public MovimentacaoEstoqueDTO atualizarMovimentacaoEstoque(Long id) {
        return null;
    }

    @Override
    public MovimentacaoEstoqueDTO buscarMovimentacaoEstoquePorId(Long id) {
        MovimentacaoEstoque movimentacaoEstoque = movimentacaoEstoqueRepository.findById(id).orElse(null);
        return modelMapper.map(movimentacaoEstoque, MovimentacaoEstoqueDTO.class);
    }

    @Override
    public void deletarMovimentacaoEstoque(Long id) {
        movimentacaoEstoqueRepository.deleteById(id);
    }
}