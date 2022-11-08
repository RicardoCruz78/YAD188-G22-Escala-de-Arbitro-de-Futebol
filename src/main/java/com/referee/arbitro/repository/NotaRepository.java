package com.referee.arbitro.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.referee.arbitro.model.Nota;

@Repository
@Transactional
public interface NotaRepository extends CrudRepository<Nota, Long> {
	@Query(value = "SELECT * FROM nota WHERE id_usuario = ?;", nativeQuery = true)
	List<Nota> filtrar(Long id);

	List<Nota> findByOrderByIdDesc();

}
