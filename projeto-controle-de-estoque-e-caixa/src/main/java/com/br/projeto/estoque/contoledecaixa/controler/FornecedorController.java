package com.br.projeto.estoque.contoledecaixa.controler;
import com.br.projeto.estoque.contoledecaixa.dto.FornecedorDTO;
import com.br.projeto.estoque.contoledecaixa.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<FornecedorDTO>> listarFornecedores() {
        List<FornecedorDTO> fornecedores = fornecedorService.listarFornecedores();
        return ResponseEntity.ok(fornecedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> buscarFornecedorPorId(@PathVariable Long id) {
        FornecedorDTO fornecedor = fornecedorService.buscarFornecedorPorId(id);
        if (fornecedor != null) {
            return ResponseEntity.ok(fornecedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<FornecedorDTO> salvarFornecedor(@RequestBody FornecedorDTO fornecedorDTO) {
        FornecedorDTO fornecedorSalvo = fornecedorService.salvarFornecedor(fornecedorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id) {
        fornecedorService.deletarFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}

