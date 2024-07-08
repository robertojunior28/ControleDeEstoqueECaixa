package com.br.projeto.estoque.contoledecaixa.dto;
import com.br.projeto.estoque.contoledecaixa.valores.FormaDePagamento;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class VendaDTO {
    private Long id;
    private Date dataVenda;
    private ClienteDTO cliente; // se aplicável
    private List<ProdutoDTO> itensVendidos;
    private double totalVenda;
    private FormaDePagamento formaPagamento;

}
