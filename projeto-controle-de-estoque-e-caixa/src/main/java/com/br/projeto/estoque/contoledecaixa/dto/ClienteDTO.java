package com.br.projeto.estoque.contoledecaixa.dto;
import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
}

