package com.springboot.posts.apirest.models.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.posts.apirest.models.entity.Answer;
import com.springboot.posts.apirest.models.repositories.IAnswerRepository;

@Service
public class AnswerServiceImpl implements IAnswerService{
	@Autowired
	private IAnswerRepository answerRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Answer> getAnswerIdComment(Long id) {
		return answerRepository.findAnswerByCommentId(id);
	}

	@Override
	@Transactional
	public Answer createAnswer(Answer answer) {
		answer.setCreated_at(new Date());
		return answerRepository.save(answer);

	}
}
