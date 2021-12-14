package com.springboot.posts.apirest.models.services;

import com.springboot.posts.apirest.models.entity.User;

public interface IUserService {

	public User getUserName(String username);
	public User getUserId(Long id);
	public User createUser(User user);
}
