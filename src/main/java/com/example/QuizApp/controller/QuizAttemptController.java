package com.example.QuizApp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizApp.model.QuizSubmitDTO;
import com.example.QuizApp.service.QuizAttemptService;

@RestController
@RequestMapping("/quiz")
public class QuizAttemptController 
{
	 @Autowired
	    private QuizAttemptService attemptService;

	    @PostMapping("/submit")
	    public ResponseEntity<String> submitQuiz(@RequestBody QuizSubmitDTO submitDTO)
	    {
	        attemptService.saveQuizAttempt(submitDTO);
	        return ResponseEntity.ok("Quiz submitted successfully!");
	    }
	    @GetMapping("/score/{quizId}/{userId}")
	    public ResponseEntity<Map<String, Object>> viewScore(
	            @PathVariable Long quizId,
	            @PathVariable Long userId) {

	        int score = attemptService.calculateScore(quizId, userId);

	        Map<String, Object> response = new HashMap<>();
	        response.put("score", score);

	        return ResponseEntity.ok(response);

//	        // optional: total questions attempted
//	        int totalQuestions = attemptService.getTotalQuestionsAttempted(quizId, userId);
//	        response.put("totalQuestions", totalQuestions);
//
//	        return ResponseEntity.ok(response);
	    }
	    

}
