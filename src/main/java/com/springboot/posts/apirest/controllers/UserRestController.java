package com.springboot.posts.apirest.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.posts.apirest.models.entity.User;
import com.springboot.posts.apirest.models.services.IUserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private IUserService userService;
	
	//@RequestMapping(method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(value="/user", consumes= {"application/json"})
	public User create(@RequestBody User user) {
		user.setCreated_at(new Date());
		return userService.createUser(user);
	}
	
	@GetMapping(value = "/user/{username}")
	public ResponseEntity<User> getUser(@PathVariable(value="username") String username) {
        return new ResponseEntity<>(userService.getUserName(username), HttpStatus.OK);
    }
}
