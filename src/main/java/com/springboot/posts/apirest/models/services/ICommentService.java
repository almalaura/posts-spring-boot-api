package com.springboot.posts.apirest.models.services;

import java.util.List;

import com.springboot.posts.apirest.models.entity.Comment;

public interface ICommentService {

	public List<Comment> getCommentIdPost(Long id);
	
	public Comment createComment(Comment comment);
}
