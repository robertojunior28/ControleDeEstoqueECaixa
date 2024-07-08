package com.br.projeto.estoque.contoledecaixa.dto;
import lombok.Data;
import java.util.Date;

@Data
public class MovimentacaoEstoqueDTO {
    private Long id;
    private String tipo; // entrada ou saída
    private Date dataMovimentacao;
    private ProdutoDTO produto;
    private int quantidade;

}
