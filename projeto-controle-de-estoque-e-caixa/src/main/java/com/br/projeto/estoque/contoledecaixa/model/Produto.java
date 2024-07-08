package com.br.projeto.estoque.contoledecaixa.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private double precoVenda;

    private double precoCompra;

    private int quantidadeEstoque;

    @ManyToMany
    private List<Fornecedor> fornecedores;

}
