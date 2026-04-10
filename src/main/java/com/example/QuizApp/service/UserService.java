package com.example.QuizApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QuizApp.model.User;
import com.example.QuizApp.repository.USerRepository;

@Service
public class UserService 
{
	@Autowired
	private USerRepository userRepository;

	public User register(User user) 
	{
		return userRepository.save(user);
		
	}

	public  User login(String email, String password)
	{
		User user=userRepository.findByEmail(email);
		 if (user == null) {
		        System.out.println("User not found");
		        return null;
		    }

		    // ✅ THEN check password
		    if (user.getPassword() != null && user.getPassword().equals(password)) {
		        return user;
		    }
		    return null;
		
	}

	 public User getProfile(Long id) 
	 {
	        return userRepository.findById(id).orElse(null);
	    }
	
	

}
