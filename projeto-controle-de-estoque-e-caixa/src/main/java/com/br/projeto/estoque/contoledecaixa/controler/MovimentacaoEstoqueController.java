package com.br.projeto.estoque.contoledecaixa.controler;
import com.br.projeto.estoque.contoledecaixa.dto.MovimentacaoEstoqueDTO;
import com.br.projeto.estoque.contoledecaixa.service.MovimentacaoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movimentacoes-estoque")
public class MovimentacaoEstoqueController {

    @Autowired
    private MovimentacaoEstoqueService movimentacaoEstoqueService;

    @GetMapping
    public ResponseEntity<List<MovimentacaoEstoqueDTO>> listarMovimentacoesEstoque() {
        List<MovimentacaoEstoqueDTO> movimentacoes = movimentacaoEstoqueService.listarMovimentacoesEstoque();
        return ResponseEntity.ok(movimentacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimentacaoEstoqueDTO> buscarMovimentacaoEstoquePorId(@PathVariable Long id) {
        MovimentacaoEstoqueDTO movimentacao = movimentacaoEstoqueService.buscarMovimentacaoEstoquePorId(id);
        if (movimentacao != null) {
            return ResponseEntity.ok(movimentacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MovimentacaoEstoqueDTO> salvarMovimentacaoEstoque(@RequestBody MovimentacaoEstoqueDTO movimentacaoEstoqueDTO) {
        MovimentacaoEstoqueDTO movimentacaoSalva = movimentacaoEstoqueService.salvarMovimentacaoEstoque(movimentacaoEstoqueDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMovimentacaoEstoque(@PathVariable Long id) {
        movimentacaoEstoqueService.deletarMovimentacaoEstoque(id);
        return ResponseEntity.noContent().build();
    }
}

