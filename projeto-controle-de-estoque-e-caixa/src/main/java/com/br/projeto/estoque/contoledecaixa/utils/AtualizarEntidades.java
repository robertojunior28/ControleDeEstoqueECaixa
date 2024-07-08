package com.br.projeto.estoque.contoledecaixa.utils;

import com.br.projeto.estoque.contoledecaixa.dto.ClienteDTO;
import com.br.projeto.estoque.contoledecaixa.dto.CompraDTO;
import com.br.projeto.estoque.contoledecaixa.dto.FornecedorDTO;
import com.br.projeto.estoque.contoledecaixa.dto.ProdutoDTO;
import com.br.projeto.estoque.contoledecaixa.model.Cliente;
import com.br.projeto.estoque.contoledecaixa.model.Compra;
import com.br.projeto.estoque.contoledecaixa.model.Fornecedor;
import com.br.projeto.estoque.contoledecaixa.model.Produto;

import java.util.List;
import java.util.Optional;

public class AtualizarEntidades {
    /**
     * Método criado com a finalidade de ajudar na atualização da entidade Cliente,
     * ele verifica se os atibutos não estão em branco ou ou preenchidos com espaços em branco
     * se entrar dentro do if significa que o DTO tem a informação e atualiza aquele atributo
     * @param clienteBancoDeDados coloca aqui a entidade que veio do banco de dados
     * @param clienteDTO coloca aqui o DTO que o cliente enviou na requisição
     * @return retorna a entidade devidamente atualizada e sem perder informações
     */
    public static Cliente atualizarCliente(Cliente clienteBancoDeDados, ClienteDTO clienteDTO){
        Cliente clienteExistente = clienteBancoDeDados;
        if(!clienteDTO.getNome().isEmpty() && !clienteDTO.getNome().isBlank()){
            clienteExistente.setNome(clienteDTO.getNome());
        }
        if(!clienteDTO.getEmail().isEmpty() && !clienteDTO.getEmail().isBlank()){
            clienteExistente.setEmail(clienteDTO.getEmail());
        }
        if(!clienteDTO.getEndereco().isEmpty() && !clienteDTO.getEndereco().isBlank()){
            clienteExistente.setEndereco(clienteDTO.getEndereco());
        }
        if(!clienteDTO.getTelefone().isEmpty() && !clienteDTO.getTelefone().isBlank()){
            clienteExistente.setTelefone(clienteDTO.getTelefone());
        }
        return clienteExistente;
    }
    /**
     * Método criado com a finalidade de ajudar na atualização da entidade Fornecedor,
     * ele verifica se os atibutos não estão em branco ou ou preenchidos com espaços em branco
     * se entrar dentro do if significa que o DTO tem a informação e atualiza aquele atributo
     * @param fornecedorBancoDeDados coloca aqui a entidade que veio do banco de dados
     * @param fornecedorDTO coloca aqui o DTO que o cliente enviou na requisição
     * @return retorna a entidade devidamente atualizada e sem perder informações
     */
    public static Fornecedor atualizarFornecedor(Fornecedor fornecedorBancoDeDados, FornecedorDTO fornecedorDTO){
        Fornecedor fornecedorExistente = fornecedorBancoDeDados;

        if(!fornecedorDTO.getNome().isEmpty() && !fornecedorDTO.getNome().isBlank()){
            fornecedorExistente.setNome(fornecedorDTO.getNome());
        }
        if(!fornecedorDTO.getEndereco().isEmpty() && !fornecedorDTO.getEndereco().isBlank()){
            fornecedorExistente.setEndereco(fornecedorDTO.getEndereco());
        }
        if(!fornecedorDTO.getEmail().isEmpty() && !fornecedorDTO.getEmail().isBlank()){
            fornecedorExistente.setEmail(fornecedorDTO.getEmail());
        }
        if(!fornecedorDTO.getTelefone().isEmpty() && !fornecedorDTO.getTelefone().isBlank()){
            fornecedorExistente.setTelefone(fornecedorDTO.getTelefone());
        }
        return fornecedorExistente;
    }

    /**
     * Método criado com a finalidade de ajudar na atualização do atibuto intensComprados da entidade Compra,
     * ele verifica se os atibutos não estão em branco ou ou preenchidos com espaços em branco
     * se entrar dentro do if significa que o DTO tem a informação e atualiza aquele atributo
     * @param produtosBancoDeDados coloca aqui a entidade que veio do banco de dados
     * @param produtosDTO coloca aqui o DTO que o cliente enviou na requisição
     * @return retorna a entidade devidamente atualizada e sem perder informações
     */
    public static List<Produto> atualizarProdutosDaCompra(List<Produto> produtosBancoDeDados, List<ProdutoDTO> produtosDTO){
        List<Produto> produtosExistentes = produtosBancoDeDados;
        // Para atualizar os itens comprados, precisamos verificar cada item
        for (ProdutoDTO itemDTO : produtosDTO) {
            // Verifica se o item já existe na lista atual
            Optional<Produto> itemExistenteOpt = produtosExistentes.stream()
                    .filter(item -> item.getId().equals(itemDTO.getId()))
                    .findFirst();

            if (itemExistenteOpt.isPresent()) {
                // Se o item existir, atualiza os campos relevantes
                Produto itemExistente = itemExistenteOpt.get();
                if(!itemDTO.getDescricao().isEmpty() && !itemDTO.getDescricao().isBlank()){
                    itemExistente.setDescricao(itemDTO.getDescricao());
                }
                if(!itemDTO.getNome().isEmpty() && !itemDTO.getNome().isBlank()){
                    itemExistente.setNome(itemDTO.getNome());
                }
                if(itemDTO.getPrecoCompra() > 0){
                    itemExistente.setPrecoCompra(itemDTO.getPrecoCompra());
                }
                if(itemDTO.getQuantidadeEstoque() > 0) {
                    itemExistente.setQuantidadeEstoque(itemDTO.getQuantidadeEstoque());
                }
                if(itemDTO.getPrecoVenda() > 0){
                    itemExistente.setPrecoVenda(itemDTO.getPrecoVenda());
                }

            }
        }
        return produtosExistentes;
    }

    /**
     * Método criado com a finalidade de ajudar na atualização da entidade Compra,
     * ele verifica se os atibutos não estão em branco ou ou preenchidos com espaços em branco
     * se entrar dentro do if significa que o DTO tem a informação e atualiza aquele atributo
     * @param compraBancoDeDados coloca aqui a entidade que veio do banco de dados
     * @param compraDTO coloca aqui o DTO que o cliente enviou na requisição
     * @return retorna a entidade devidamente atualizada e sem perder informações
     */
    public static Compra atualizarCompra(Compra compraBancoDeDados, CompraDTO compraDTO){
        Compra compraExistente = compraBancoDeDados;
        if (compraDTO.getDataCompra() != null) {
            compraExistente.setDataCompra(compraDTO.getDataCompra());
        }
        if(compraDTO.getTotalCompra() > 0){
            compraExistente.setTotalCompra(compraDTO.getTotalCompra());
        }

        //atualizar fornecedor aqui
        if(compraDTO.getFornecedor() != null){
            compraExistente.setFornecedor(AtualizarEntidades.atualizarFornecedor(compraExistente.getFornecedor(), compraDTO.getFornecedor()));
        }

        if (compraDTO.getItensComprados() != null) {
            compraExistente.setItensComprados(AtualizarEntidades.atualizarProdutosDaCompra(compraExistente.getItensComprados(), compraDTO.getItensComprados()));
        }
        return compraExistente;
    }

}
