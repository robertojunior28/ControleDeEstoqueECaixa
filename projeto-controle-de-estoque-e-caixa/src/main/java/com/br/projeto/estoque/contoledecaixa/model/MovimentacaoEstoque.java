package com.br.projeto.estoque.contoledecaixa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class MovimentacaoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // entrada ou saída

    private Date dataMovimentacao;

    @ManyToOne
    private Produto produto;

    private int quantidade;

}
