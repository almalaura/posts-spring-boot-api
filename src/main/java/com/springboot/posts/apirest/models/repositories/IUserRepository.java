package com.springboot.posts.apirest.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.posts.apirest.models.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u where u.username = :username")
	User findByUsername(@Param("username") String username);
}
