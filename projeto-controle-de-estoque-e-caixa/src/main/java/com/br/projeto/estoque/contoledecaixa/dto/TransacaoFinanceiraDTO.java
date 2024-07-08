package com.br.projeto.estoque.contoledecaixa.dto;
import lombok.Data;
import java.util.Date;

@Data
public class TransacaoFinanceiraDTO {
    private Long id;
    private String tipo; // receita ou despesa
    private Date dataTransacao;
    private String descricao;
    private double valor;

}
