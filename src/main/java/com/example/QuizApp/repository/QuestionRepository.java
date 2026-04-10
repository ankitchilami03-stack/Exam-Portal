package com.example.QuizApp.repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.QuizApp.model.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Long>
{
	@Query(value = "SELECT * FROM questions q WHERE q.category = :category ORDER BY RAND()", nativeQuery = true)
	List<Questions> findRandomQuestionByCategory(@Param("category") String category, Pageable pageable);
}
