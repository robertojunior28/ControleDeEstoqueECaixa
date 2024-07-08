package com.br.projeto.estoque.contoledecaixa.service.impl;
import com.br.projeto.estoque.contoledecaixa.dto.ProdutoDTO;
import com.br.projeto.estoque.contoledecaixa.model.Produto;
import com.br.projeto.estoque.contoledecaixa.repository.ProdutoRepository;
import com.br.projeto.estoque.contoledecaixa.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(produto -> modelMapper.map(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO) {
        Produto produto = modelMapper.map(produtoDTO, Produto.class);
        produto = produtoRepository.save(produto);
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    @Override
    public ProdutoDTO atualizarProduto(Long id) {
        return null;
    }

    @Override
    public ProdutoDTO buscarProdutoPorId(Long id) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    @Override
    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
