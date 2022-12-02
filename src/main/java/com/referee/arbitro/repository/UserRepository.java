package com.referee.arbitro.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.referee.arbitro.model.User;
import java.util.List;
import java.util.Optional;



@Repository
@Transactional

public interface UserRepository extends JpaRepository<User, Long> { 
	User findByEmail( String email);
	 @Query(value = "SELECT * from  user u WHERE u.nome like %:keyword%",nativeQuery = true)

	 List<User> findByKeyword(@Param("keyword") String keyword);
 /*
	 @Query(value = "SELECT * from  user WHERE id=?  ;" ,nativeQuery = true)
	 Optional<User> findById(@Param("id") Long id);
*/
	
}