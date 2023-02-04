package com.map;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	
	@Id
	@Column(name= "question_id")
	private int questionId;
	private String question;
	
	/* One to One relationship
	 * @OneToOne
	 * 
	 * @JoinColumn(name="a_id") // to rename the foreign key column use with OneToOne and related annotations 
	 * private Answer answer;
	 */
	
	/*
	 * One to Many relationship
	 */
	@OneToMany (mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL) //FetchType.LAZY
	private List<Answer> answers;
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Question(int questionId, String question, List<Answer> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}



	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	

}
