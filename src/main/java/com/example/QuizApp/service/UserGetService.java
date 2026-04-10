package com.example.QuizApp.service;

import java.beans.Transient;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QuizApp.model.User;
import com.example.QuizApp.repository.QuizAttemptRepository;
import com.example.QuizApp.repository.UserGetRepository;

import jakarta.transaction.Transactional;

@Service
public class UserGetService
{

	@Autowired
	UserGetRepository userGetRepository;
	
	@Autowired
	QuizAttemptRepository quizAttemptRepository;

	public List<User> getAllUser() 
	{
		return userGetRepository.findAll();
	}

	
	@Transactional
	public void deleteUser(Long id) 
	{
		 User user = userGetRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found"));
		 quizAttemptRepository.deleteByUserId(id);
		 userGetRepository.delete(user);
		
	}
	

}
