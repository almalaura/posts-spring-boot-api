package com.springboot.posts.apirest.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.posts.apirest.models.entity.Post;
import com.springboot.posts.apirest.models.services.IPostService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PostRestController {
	
	@Autowired
	private IPostService postService;
	
	@GetMapping("/posts")
	public ResponseEntity<List<?>> getAllPost() {
		List<Post> posts = postService.getAllPost();
		if (posts == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(posts);
	}
	
	@PostMapping("/post")
	public ResponseEntity<?> createPost(@RequestBody Post post) {
		Post postCreated = postService.createPost(post);
		post.setCreated_at(new Date());
		return ResponseEntity.status(HttpStatus.CREATED).body(postCreated);
	}
	

}
