package com.springboot.posts.apirest.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.posts.apirest.models.entity.Answer;
import com.springboot.posts.apirest.models.services.IAnswerService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AnswerRestController {
	@Autowired
	private IAnswerService answerService;

	@GetMapping(value = "/replies/{id}")
	public ResponseEntity<?> getAnswerIdComment(@PathVariable(value = "id") Long id) {
		List<Answer> answers = answerService.getAnswerIdComment(id);
		if (answers == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(answers);
	}
	
	@PostMapping(value="/replies")
	public ResponseEntity<?> createAnswer(@RequestBody Answer answer) {
		Answer reply = answerService.createAnswer(answer);
		reply.setCreated_at(new Date());
		return ResponseEntity.status(HttpStatus.CREATED).body(reply);
	}
}
