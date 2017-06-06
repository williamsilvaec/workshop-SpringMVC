package com.algaworks.cobranca.repository;

import com.algaworks.cobranca.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by william on 02/06/2017.
 */
public interface Titulos extends JpaRepository<Titulo, Long> {

    public List<Titulo> findByDescricaoContaining(String descricao);
}
