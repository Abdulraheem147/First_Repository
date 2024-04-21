package com.sample;

import java.util.List;

public class Question {

	private String question;
	private List<Object> option;
	private int correctoption;
	
	
	public Question(String question, List<Object> option, int correctoption) {
		super();
		this.question = question;
		this.option = option;
		this.correctoption = correctoption; 
	}

	public String getQuestion() {
		return question;
	}


	public List<Object> getOption() {
		return option;
	}

	public int getCorrectoption() {
		return correctoption;
	}

	
	

}
