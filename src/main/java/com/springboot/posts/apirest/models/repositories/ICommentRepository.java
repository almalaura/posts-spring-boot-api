package com.springboot.posts.apirest.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.posts.apirest.models.entity.Comment;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long>{
	List<Comment> findCommentByPostId(Long id);
}
