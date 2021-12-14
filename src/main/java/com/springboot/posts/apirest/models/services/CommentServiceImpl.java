package com.springboot.posts.apirest.models.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.posts.apirest.models.entity.Comment;
import com.springboot.posts.apirest.models.repositories.ICommentRepository;

@Service
public class CommentServiceImpl implements ICommentService {
	@Autowired
	private ICommentRepository commentRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Comment> getCommentIdPost(Long id) {
		return commentRepository.findCommentByPostId(id);
	}

	@Override
	@Transactional
	public Comment createComment(Comment comment) {
		comment.setCreated_at(new Date());
		return commentRepository.save(comment);

	}

}
