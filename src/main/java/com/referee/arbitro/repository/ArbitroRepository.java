package com.referee.arbitro.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.referee.arbitro.model.Arbitro;

@Repository
@Transactional
public interface ArbitroRepository extends CrudRepository<Arbitro, Long> {
	
	@Query(value = "SELECT * from  arbitro a WHERE a.disponibilidade like %:keyword%"
			+ " or a.escolaridade like %:keyword% or a.funcao like %:keyword%"			
			,nativeQuery = true)
	
	public List<Arbitro> findByKeyword(String keyword);
	
	List<Arbitro> findByOrderByIdDesc();
	@Query(value = "SELECT * FROM arbitro WHERE id_login = ?;", nativeQuery = true)
	public List<Arbitro> filtrar(Long id);
	
	
	/*
	@Query(value = "SELECT * FROM arbitro WHERE id_login = ?;", nativeQuery = true)
	public List<Arbitro> filtrar(Long id);

	List<Arbitro> findByOrderByIdDesc();
	@Query(value = "SELECT * FROM arbitro WHERE id_login = ?;", nativeQuery = true)
	public List<Arbitro> findByKeyword(String keyword);





+ "or a.escolaridade like %:keyword%"
			+ "or a.funcao like %:keyword%"
			+ "or a.anoFormacaoArbitro like %:keyword% 
	*/

	

}
