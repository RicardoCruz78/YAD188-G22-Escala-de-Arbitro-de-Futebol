package com.referee.arbitro.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.referee.arbitro.model.Arbitro;

@Repository
@Transactional
public interface ArbitroRepository extends CrudRepository<Arbitro, Long> {
	@Query(value = "SELECT * FROM arbitro WHERE id_login = ?;", nativeQuery = true)
	public List<Arbitro> filtrar(Long id);

	List<Arbitro> findByOrderByIdDesc();

}
