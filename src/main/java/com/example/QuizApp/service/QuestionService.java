package com.example.QuizApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QuizApp.model.Questions;
import com.example.QuizApp.repository.QuestionRepository;
import com.example.QuizApp.repository.QuizAttemptRepository;

import jakarta.transaction.Transactional;

@Service
public class QuestionService 
{
	@Autowired
	QuestionRepository questionRepository;
	 @Autowired
	  QuizAttemptRepository quizAttemptRepository;
	//addquestions
	public void addQuestion(Questions questions) 
	{
		questionRepository.save(questions);
		
	}

	//get all questions
	public List<Questions> getAllQuestions()
	{
		return questionRepository.findAll();
		
	}
	
	//update questions
	
	public Questions updateQuestion(Long id, Questions newQuestion) {

	    Questions oldQuestion = questionRepository.findById(id).orElse(null);

	    if (oldQuestion != null) {

	        oldQuestion.setQuestionTitle(newQuestion.getQuestionTitle());
	        oldQuestion.setOption1(newQuestion.getOption1());
	        oldQuestion.setOption2(newQuestion.getOption2());
	        oldQuestion.setOption3(newQuestion.getOption3());
	        oldQuestion.setOption4(newQuestion.getOption4());
	        oldQuestion.setCorrectAnswer(newQuestion.getCorrectAnswer());
	        oldQuestion.setDifficultyLevel(newQuestion.getDifficultyLevel());
	        oldQuestion.setCategory(newQuestion.getCategory());

	        return questionRepository.save(oldQuestion);
	    }

	    return null;
	}
	//delete Question
	 @Transactional
	    public String deleteQuestion(Long id) {

	        if (questionRepository.existsById(id)) {

	            // 1️⃣ delete related quiz attempts
	            quizAttemptRepository.deleteByQuestionId(id);

	            // 2️⃣ delete question
	            questionRepository.deleteById(id);

	            return "Question Deleted Successfully";
	        } else {
	            return "Question Not Found";
	        }
	 }
}
