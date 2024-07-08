package com.br.projeto.estoque.contoledecaixa.repository;
import com.br.projeto.estoque.contoledecaixa.model.MovimentacaoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoEstoqueRepository extends JpaRepository<MovimentacaoEstoque, Long> {
    // Métodos personalizados de consulta podem ser adicionados aqui, se necessário
}
