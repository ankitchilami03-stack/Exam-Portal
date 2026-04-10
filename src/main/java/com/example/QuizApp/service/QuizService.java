package com.example.QuizApp.service;
import org.springframework.stereotype.Service;

import com.example.QuizApp.model.QuestionDTO;
import com.example.QuizApp.model.Questions;
import com.example.QuizApp.model.Quiz;
import com.example.QuizApp.model.QuizDTO;
import com.example.QuizApp.repository.QuestionRepository;
import com.example.QuizApp.repository.QuizSaveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizSaveRepository quizSaveRepository;

    public QuizDTO generateRandomQuiz(String category, int numQ)
    {
    	   // 1️⃣ Save quiz info in DB
        Quiz quizEntity = new Quiz();
        quizEntity.setCategory(category);
        quizEntity.setTitle("Exam: " + category);
        quizEntity.setCreatedAt(LocalDateTime.now());
        
        quizSaveRepository.save(quizEntity); // saves and generates ID

        // Step 1: fetch random questions from DB
    	List<Questions> questions = questionRepository.findRandomQuestionByCategory(category, PageRequest.of(0, numQ));
        // Step 2: map entities to DTOs
        List<QuestionDTO> questionDTOs = questions.stream().map(q -> {
            QuestionDTO dto = new QuestionDTO();
            dto.setId(q.getId());
            dto.setQuestionTitle(q.getQuestionTitle());
            dto.setOption1(q.getOption1());
            dto.setOption2(q.getOption2());
            dto.setOption3(q.getOption3());
            dto.setOption4(q.getOption4());
            return dto;
        }).collect(Collectors.toList());

        // Step 3: build QuizDTO
        QuizDTO quiz = new QuizDTO();
        quiz.setCategory(category);
        quiz.setTitle("Exam: " + category);
        quiz.setQuestions(questionDTOs);

        return quiz;
    }
}