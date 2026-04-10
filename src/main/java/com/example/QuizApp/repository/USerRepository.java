package com.example.QuizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.QuizApp.model.User;

@Repository
public interface USerRepository extends JpaRepository<User, Long>
{
	User findByEmail(String email);

}
