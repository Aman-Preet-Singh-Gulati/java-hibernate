package com.map;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        // Creating question
        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("What is JAVA?");
        
        // Creating answer 1
        Answer ans = new Answer();
        ans.setAnswerId(343);
        ans.setAnswer("Java is programming language");
        ans.setQuestion(q1);
        //q1.setAnswer(ans);
        
        // Creating answer 2 for many to one (many answers to one question)
        Answer ans1 = new Answer();
        ans1.setAnswerId(33);
        ans1.setAnswer("with the help of JAVA we can create software");
        ans1.setQuestion(q1);
        
        // Creating answer 2 for many to one (many answers to one question)
        Answer ans2 = new Answer();
        ans2.setAnswerId(34);
        ans2.setAnswer("Java has different types of framework");
        ans2.setQuestion(q1);
        
        List<Answer> list = new ArrayList<Answer>();
        list.add(ans);
        list.add(ans1);
        list.add(ans2);
        
        q1.setAnswers(list);
        
		/*
		 * // Creating question Question q2 = new Question(); q2.setQuestionId(1213);
		 * q2.setQuestion("What is collection framework?");
		 * 
		 * // Creating answer Answer ans1 = new Answer(); ans1.setAnswerId(344);
		 * ans1.setAnswer("API to work with objects in java"); ans1.setQuestion(q2);
		 * q2.setAnswer(ans1);
		 */
        
        // Session
        Session s = factory.openSession();
        
        // Transaction
        Transaction tx = s.beginTransaction();
        
        // Save
		/* For one to one relationship
		 * s.save(q1); 
		 * s.save(q2); 
		 * s.save(ans1); 
		 * s.save(ans);
		 */	
        
		/* For one to many relationship */
		/*
		 * s.save(q1); 
		 * s.save(ans); 
		 * s.save(ans1); 
		 * s.save(ans2);
		 */
		 
        
        tx.commit();
        
        // Fetching for One to Many/ Many to One 
        
        Question q = (Question)s.get(Question.class, 1212);
        System.out.println(q.getQuestion());
        System.out.println(q.getQuestionId());
        // Lazy loading
//        System.out.println(q.getAnswers().size());
        
        for (Answer a: q.getAnswers())
        {
        	System.out.println(a.getAnswer());
        }
        
        // Fetching for one to one
        
		/*
		 * Question ques = (Question) s.get(Question.class, 1212);
		 * System.out.println(ques.getQuestion());
		 * System.out.println(ques.getAnswer().getAnswer());
		 */
        
        s.close();
        
        factory.close();
	}
}