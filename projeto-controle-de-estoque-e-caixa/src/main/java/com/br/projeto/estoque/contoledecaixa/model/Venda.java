package com.br.projeto.estoque.contoledecaixa.model;

import com.br.projeto.estoque.contoledecaixa.valores.FormaDePagamento;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataVenda;

    @ManyToOne
    private Cliente cliente; // se aplicável

    @ManyToMany
    private List<Produto> itensVendidos;

    private double totalVenda;

    @Enumerated(EnumType.STRING)
    private FormaDePagamento formaPagamento;

}