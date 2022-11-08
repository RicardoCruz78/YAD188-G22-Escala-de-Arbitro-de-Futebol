package com.referee.arbitro.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.referee.arbitro.model.Escala;

@Repository
@Transactional
public interface EscalaRepository extends CrudRepository<Escala, Long> {

	@Query(value = "select * from escala  where arbitro = :id or assistente1 = :id or assistente2 = :id or quarto_arbitro = :id", nativeQuery = true)

	public List<Escala> filtrar(Long id);

	public List<Escala> findByOrderByIdDesc();

}
