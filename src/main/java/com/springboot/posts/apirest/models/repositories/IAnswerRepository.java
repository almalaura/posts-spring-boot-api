package com.springboot.posts.apirest.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.posts.apirest.models.entity.Answer;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer, Long>{
	List<Answer> findAnswerByCommentId(Long id);
}
