package com.springboot.posts.apirest.models.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.posts.apirest.models.entity.User;
import com.springboot.posts.apirest.models.repositories.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public User getUserName(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	@Transactional(readOnly = true)
	public User getUserId(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public User createUser(User user) {
		user.setCreated_at(new Date());
		return userRepository.save(user);
	}
}
