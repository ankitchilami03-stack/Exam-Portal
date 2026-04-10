package com.example.QuizApp.model;

public class QuestionAnswerDTO
{
	private Long questionId;
    private String selectedOption;

    // getters & setters
    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }

    public String getSelectedOption() { return selectedOption; }
    public void setSelectedOption(String selectedOption)
    { this.selectedOption = selectedOption; 
    }
    

}
