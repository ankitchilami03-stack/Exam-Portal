package com.example.QuizApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizApp.model.QuizDTO;
import com.example.QuizApp.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController 
{
	@Autowired
	QuizService quizService;
	@PostMapping("/start")
    public ResponseEntity<QuizDTO> startExam(
            @RequestParam String category,
            @RequestParam int noOfQuestions) {

        QuizDTO quiz = quizService.generateRandomQuiz(category, noOfQuestions);
        return ResponseEntity.ok(quiz);
    }
}
