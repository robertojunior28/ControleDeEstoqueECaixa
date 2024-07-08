package com.br.projeto.estoque.contoledecaixa.dto;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class CompraDTO {
    private Long id;
    private Date dataCompra;
    private FornecedorDTO fornecedor;
    private List<ProdutoDTO> itensComprados;
    private double totalCompra;

}
