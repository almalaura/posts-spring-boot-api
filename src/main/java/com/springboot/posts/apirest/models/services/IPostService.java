package com.springboot.posts.apirest.models.services;

import java.util.List;

import com.springboot.posts.apirest.models.entity.Post;

public interface IPostService {
	
	public List<Post> getAllPost();
	
	public Post createPost(Post post);

}
