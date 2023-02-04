package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Answer {

	@Id
	@Column(name ="answer_id")
	private int answerId;
	private String answer;
	
	/* One to One relationship
	 * @OneToOne(mappedBy = "answer") 
	 * To ignore making question id as foreign key in answer table 
	 * because we already have the foreign key in question table
	 * just for sake of establishing the bi-directional relation OneToOne //
	 * Annotation is added here.
	 */
	/*
	 * Many to One relationship
	 */
	@ManyToOne
	private Question question;
	
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Answer(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
