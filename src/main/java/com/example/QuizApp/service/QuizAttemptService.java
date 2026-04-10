package com.example.QuizApp.service;

import java.beans.Transient;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QuizApp.model.Quiz;
import com.example.QuizApp.model.Questions;
import com.example.QuizApp.model.QuizAttempt;
import com.example.QuizApp.model.QuizSubmitDTO;
import com.example.QuizApp.model.User;
import com.example.QuizApp.repository.QuestionRepository;
import com.example.QuizApp.repository.QuizAttemptRepository;
import com.example.QuizApp.repository.QuizRepository;
import com.example.QuizApp.repository.USerRepository;

import jakarta.transaction.Transactional;

@Service
public class QuizAttemptService {

    @Autowired
    private QuizAttemptRepository attemptRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private USerRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Transactional
    public void saveQuizAttempt(QuizSubmitDTO submitDTO) 
    {
    	 attemptRepository.deleteByQuizIdAndUserId(
    		        submitDTO.getQuizId(),
    		        submitDTO.getUserId()
    		    );

    	Quiz quiz = quizRepository.findById(submitDTO.getQuizId())
    	        .orElseThrow(() -> new RuntimeException("Quiz not found"));

        User user = userRepository.findById(submitDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<QuizAttempt> attempts = submitDTO.getAnswers().stream().map(a -> {
            QuizAttempt qa = new QuizAttempt();
            qa.setQuiz(quiz);
            qa.setUser(user);

            Questions question = questionRepository.findById(a.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));

            qa.setQuestion(question);
            qa.setSelectedOption(a.getSelectedOption());
            return qa;
        }).collect(Collectors.toList());

        attemptRepository.saveAll(attempts);
    }

	public int calculateScore(Long quizId, Long userId) 
	{
		 List<QuizAttempt> attempts = attemptRepository.findByQuizIdAndUserId(quizId, userId);

		    int score = 0;
		    for (QuizAttempt attempt : attempts)
		    {
		    	if (attempt.getSelectedOption() != null &&
		    		    attempt.getSelectedOption().equals(attempt.getQuestion().getCorrectAnswer()))
		    		{
		    		    score++;
		    		}
		    }
		return score;
	}

	

	public int getTotalQuestionsAttempted(Long quizId, Long userId) 
	{
	    return attemptRepository.findByQuizIdAndUserId(quizId, userId).size();
	}
	
	
	//delete User when then delete rference table value also
	
}