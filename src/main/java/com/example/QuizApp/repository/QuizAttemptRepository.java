package com.example.QuizApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.QuizApp.model.QuizAttempt;

import jakarta.transaction.Transactional;

@Repository
public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {
    List<QuizAttempt> findByQuiz_IdAndUser_Id(Long quizId, Long userId);

	List<QuizAttempt> findByQuizIdAndUserId(Long quizId, Long userId);
	
	@Modifying
    @Query("DELETE FROM QuizAttempt q WHERE q.question.id = :id")
    void deleteByQuestionId(Long id);
	
	void deleteByQuizIdAndUserId(Long quizId, Long userId);
	
	//when delete user automaticllay dlete reference table value
	@Modifying
	@Transactional
    void deleteByUserId(Long userId);

}