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
	User findByEmail( String email);
	 @Query(value = "SELECT * from  user WHERE cpf=?  ;" ,nativeQuery = true)

	 List<User> findByKeyword(@Param("keyword") String keyword);
 



	
}