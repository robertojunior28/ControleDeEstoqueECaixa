package com.br.projeto.estoque.contoledecaixa.controler;
import com.br.projeto.estoque.contoledecaixa.dto.VendaDTO;
import com.br.projeto.estoque.contoledecaixa.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<VendaDTO>> listarVendas() {
        List<VendaDTO> vendas = vendaService.listarVendas();
        return ResponseEntity.ok(vendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaDTO> buscarVendaPorId(@PathVariable Long id) {
        VendaDTO venda = vendaService.buscarVendaPorId(id);
        if (venda != null) {
            return ResponseEntity.ok(venda);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<VendaDTO> salvarVenda(@RequestBody VendaDTO vendaDTO) {
        VendaDTO vendaSalva = vendaService.salvarVenda(vendaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVenda(@PathVariable Long id) {
        vendaService.deletarVenda(id);
        return ResponseEntity.noContent().build();
    }
}

