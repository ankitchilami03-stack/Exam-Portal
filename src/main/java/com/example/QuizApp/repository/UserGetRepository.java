package com.example.QuizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QuizApp.model.User;

public interface UserGetRepository extends JpaRepository<User, Long>
{

}
