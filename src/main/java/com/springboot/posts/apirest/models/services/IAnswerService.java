package com.springboot.posts.apirest.models.services;

import java.util.List;

import com.springboot.posts.apirest.models.entity.Answer;

public interface IAnswerService {

	public List<Answer> getAnswerIdComment(Long id);
	
	public Answer createAnswer(Answer answer);
}
