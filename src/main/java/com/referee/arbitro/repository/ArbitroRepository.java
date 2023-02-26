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

	@Query(value = "SELECT * from  arbitro a inner join user u on u.id = a.id_login WHERE u.nome like %:keyword% or"
			+ " a.disponibilidade like %:keyword% "
			+ " or a.escolaridade like %:keyword% or a.ano_formacao_arbitro like %:keyword% "
			+ "or a.funcao like %:keyword%", nativeQuery = true)

	public List<Arbitro> findByKeyword(String keyword);

	List<Arbitro> findByOrderByIdDesc();

	@Query(value = "SELECT * FROM arbitro WHERE id_login = ?;", nativeQuery = true)
	public List<Arbitro> filtrar(Long id);

	/*
	 * 
	 * select u.nome from user u inner join arbitro a on u.id = a.id
	 * 
	 * 
	 * 
	 * 
	 * 
	 * List<Arbitro> findByOrderByIdDesc();
	 * 
	 * @Query(value = "SELECT * FROM arbitro WHERE id_login = ?;", nativeQuery =
	 * true) public List<Arbitro> findByKeyword(String keyword);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * + "or a.escolaridade like %:keyword%" + "or a.funcao like %:keyword%" + "or
	 * a.anoFormacaoArbitro like %:keyword%
	 */

}
