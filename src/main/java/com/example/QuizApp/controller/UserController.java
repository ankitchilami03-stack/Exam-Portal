package com.example.QuizApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizApp.model.User;
import com.example.QuizApp.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController
{
	@Autowired
	UserService userService;
	
	//Register Api
	@PostMapping("/register")
	public String registerUser(@RequestBody User user)
	{
		userService.register(user); 
		return "User Successfully Register";
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {

	    User loggedUser = userService.login(user.getEmail(), user.getPassword());

	    if (loggedUser == null) {
	        return ResponseEntity.status(401).body("Invalid email or password");
	    }

	    return ResponseEntity.ok(loggedUser);
	}

}
