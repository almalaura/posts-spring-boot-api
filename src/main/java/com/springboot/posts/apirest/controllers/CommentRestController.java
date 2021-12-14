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

import com.springboot.posts.apirest.models.entity.Comment;
import com.springboot.posts.apirest.models.services.ICommentService;

@RestController
@RequestMapping(value = "/api/")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CommentRestController {
	@Autowired
	private ICommentService commentService;

	@GetMapping(value = "comments/{id}")
	public ResponseEntity<?> getCommentIdPost(@PathVariable(value = "id") Long id) {
		List<Comment> comments = commentService.getCommentIdPost(id);
		if (comments == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(comments);
	}
	
	@PostMapping("/comment")
	public ResponseEntity<?> createComment(@RequestBody Comment comment) {
		Comment commentCreated = commentService.createComment(comment);
		comment.setCreated_at(new Date());
		return ResponseEntity.status(HttpStatus.CREATED).body(commentCreated);
	}
}

