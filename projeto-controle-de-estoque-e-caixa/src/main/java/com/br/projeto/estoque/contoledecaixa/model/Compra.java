package com.br.projeto.estoque.contoledecaixa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataCompra;

    @ManyToOne
    private Fornecedor fornecedor;

    @ManyToMany
    private List<Produto> itensComprados;

    private double totalCompra;

}
