package com.br.projeto.estoque.contoledecaixa.repository;

import com.br.projeto.estoque.contoledecaixa.model.Fornecedor;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    // Métodos personalizados de consulta podem ser adicionados aqui, se necessário
}