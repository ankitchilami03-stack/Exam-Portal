package com.example.QuizApp.repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.QuizApp.model.Questions;
import com.example.QuizApp.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long>
{
	

}
