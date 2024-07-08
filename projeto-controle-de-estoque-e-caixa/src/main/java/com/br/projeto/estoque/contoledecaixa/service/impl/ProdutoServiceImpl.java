package com.br.projeto.estoque.contoledecaixa.service.impl;
import com.br.projeto.estoque.contoledecaixa.dto.MovimentacaoEstoqueDTO;
import com.br.projeto.estoque.contoledecaixa.dto.ProdutoDTO;
import com.br.projeto.estoque.contoledecaixa.model.MovimentacaoEstoque;
import com.br.projeto.estoque.contoledecaixa.model.Produto;
import com.br.projeto.estoque.contoledecaixa.repository.ProdutoRepository;
import com.br.projeto.estoque.contoledecaixa.service.ProdutoService;
import com.br.projeto.estoque.contoledecaixa.utils.AtualizarEntidades;
import jakarta.persistence.EntityNotFoundException;
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
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Compra não encontrada com o ID: " + id));

        // Atualiza os dados da compra existente com os dados do compraDTO
        Produto produtoValidado = AtualizarEntidades.atualizarProduto(produtoExistente, produtoDTO);

        // Salva a compra atualizada no banco de dados
        Produto produtoAtualizado = produtoRepository.save(produtoValidado);

        // Retorna o CompraDTO correspondente à compra atualizada
        return modelMapper.map(produtoAtualizado, ProdutoDTO.class);
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
