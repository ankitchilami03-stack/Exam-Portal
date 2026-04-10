package com.example.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizApp.model.Questions;
import com.example.QuizApp.service.QuestionService;

@RestController
@RequestMapping("/admin")
public class QuestionController 
{
	@Autowired
	private QuestionService questionService;
	
	//add questions
	@RequestMapping("/addQuestions")
	public String addQuestion(@RequestBody Questions questions)
	{
		questionService.addQuestion(questions);
		return "successfully added questions";
		
	}
	
	@GetMapping("/questions")
	public List<Questions> getAllQuestions()
	{
	    return questionService.getAllQuestions();
	}
	
	//update question
	
	@PutMapping("/updatequestion/{id}")
	public String updateQuestion(@PathVariable Long id, @RequestBody Questions question) {

	    Questions updated = questionService.updateQuestion(id, question);

	    if (updated != null) {
	        return "Question Updated Successfully";
	    } else {
	        return "Question Not Found";
	    }
	}
	
	//delete question based on id
	@DeleteMapping("/deletequestion/{id}")
	public String deleteQuestion(@PathVariable Long id) {
	    return questionService.deleteQuestion(id);
	}
}
