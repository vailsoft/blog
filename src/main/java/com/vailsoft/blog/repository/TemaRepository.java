package com.vailsoft.blog.repository;

import com.vailsoft.blog.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {
    // Consulta por descrição
    public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
    // Consulta por


}
