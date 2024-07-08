package com.br.projeto.estoque.contoledecaixa.controler;
import com.br.projeto.estoque.contoledecaixa.dto.TransacaoFinanceiraDTO;
import com.br.projeto.estoque.contoledecaixa.service.TransacaoFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transacoes-financeiras")
public class TransacaoFinanceiraController {

    @Autowired
    private TransacaoFinanceiraService transacaoFinanceiraService;

    @GetMapping
    public ResponseEntity<List<TransacaoFinanceiraDTO>> listarTransacoesFinanceiras() {
        List<TransacaoFinanceiraDTO> transacoes = transacaoFinanceiraService.listarTransacoesFinanceiras();
        return ResponseEntity.ok(transacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoFinanceiraDTO> buscarTransacaoFinanceiraPorId(@PathVariable Long id) {
        TransacaoFinanceiraDTO transacao = transacaoFinanceiraService.buscarTransacaoFinanceiraPorId(id);
        if (transacao != null) {
            return ResponseEntity.ok(transacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TransacaoFinanceiraDTO> salvarTransacaoFinanceira(@RequestBody TransacaoFinanceiraDTO transacaoFinanceiraDTO) {
        TransacaoFinanceiraDTO transacaoSalva = transacaoFinanceiraService.salvarTransacaoFinanceira(transacaoFinanceiraDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTransacaoFinanceira(@PathVariable Long id) {
        transacaoFinanceiraService.deletarTransacaoFinanceira(id);
        return ResponseEntity.noContent().build();
    }
}
