package com.bluemobi.pro.entity;

import java.io.Serializable;

/**
 * 
 * @author yesong
 *
 */
public class Question implements Serializable{
	private static final long serialVersionUID = 4968810246956371299L;

	private Integer id;
	
	private String question;
	
	private String answer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
