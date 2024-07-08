package com.br.projeto.estoque.contoledecaixa.dto;
import lombok.Data;

@Data
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private double precoVenda;
    private double precoCompra;
    private int quantidadeEstoque;
}
