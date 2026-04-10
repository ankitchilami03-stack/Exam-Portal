package com.example.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizApp.model.User;
import com.example.QuizApp.service.UserGetService;

@RestController
@RequestMapping("/quiz")
public class UsersGetController
{
	@Autowired
	UserGetService userGetService;
	@GetMapping("/getusers")
	public List<User> getAllUsers()
	{
		return userGetService.getAllUser();
	}
	
	@DeleteMapping("/delete/{id}")
	public  String  deleteUser(@PathVariable Long id)
	{
		userGetService.deleteUser(id);
		return "User Deleteed Successfully";
	}
	
	//fetch users in admin portal
	
	

}
