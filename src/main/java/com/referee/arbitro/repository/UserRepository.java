package com.referee.arbitro.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.referee.arbitro.model.User;
import java.util.List;

@Repository
@Transactional

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT * from  user u WHERE u.nome like %:keyword%", nativeQuery = true)

	List<User> findByKeyword(@Param("keyword") String keyword);
	/*
	 * @Query(value = "SELECT * from  user WHERE id=?  ;" ,nativeQuery = true)
	 * Optional<User> findById(@Param("id") Long id);
	 */

	@Query("SELECT u FROM User u WHERE u.email = ?1")
	User findByEmail(String email);

	public User findByResetPasswordToken(String token);

}
