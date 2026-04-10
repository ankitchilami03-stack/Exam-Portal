
package com.example.QuizApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizApp.model.User;
import com.example.QuizApp.service.UserService;

@RestController
	@RequestMapping("/user")
	public class ProfileController  {

	    @Autowired
	    private UserService userService;

	    @GetMapping("/profile/{id}")
	    public ResponseEntity<User> getProfile(@PathVariable Long id) {

	        User user = userService.getProfile(id);

	        return ResponseEntity.ok(userService.getProfile(id));
	    }
}
