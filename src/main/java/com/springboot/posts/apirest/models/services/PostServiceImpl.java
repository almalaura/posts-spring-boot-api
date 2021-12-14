package com.springboot.posts.apirest.models.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.posts.apirest.models.entity.Post;
import com.springboot.posts.apirest.models.repositories.IPostRepository;

@Service
public class PostServiceImpl implements IPostService{
	
	@Autowired
	private IPostRepository postRepository;

	@Override	
	@Transactional(readOnly = true)
	public List<Post> getAllPost() {
		return postRepository.findAll();
	}

	@Override
	public Post createPost(Post post) {
		post.setCreated_at(new Date());
		return postRepository.save(post);
	}

}
