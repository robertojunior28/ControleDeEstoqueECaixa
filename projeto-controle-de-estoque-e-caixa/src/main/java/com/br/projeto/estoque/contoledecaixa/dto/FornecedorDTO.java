package com.br.projeto.estoque.contoledecaixa.dto;
import lombok.Data;

@Data
public class FornecedorDTO {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
}
