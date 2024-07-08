package com.br.projeto.estoque.contoledecaixa.controler;
import com.br.projeto.estoque.contoledecaixa.dto.CompraDTO;
import com.br.projeto.estoque.contoledecaixa.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @GetMapping
    public ResponseEntity<List<CompraDTO>> listarCompras() {
        List<CompraDTO> compras = compraService.listarCompras();
        return ResponseEntity.ok(compras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraDTO> buscarCompraPorId(@PathVariable Long id) {
        CompraDTO compra = compraService.buscarCompraPorId(id);
        if (compra != null) {
            return ResponseEntity.ok(compra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CompraDTO> salvarCompra(@RequestBody CompraDTO compraDTO) {
        CompraDTO compraSalva = compraService.salvarCompra(compraDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(compraSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCompra(@PathVariable Long id) {
        compraService.deletarCompra(id);
        return ResponseEntity.noContent().build();
    }
}

