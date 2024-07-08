package com.br.projeto.estoque.contoledecaixa.repository;
import com.br.projeto.estoque.contoledecaixa.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Métodos personalizados de consulta podem ser adicionados aqui, se necessário
}