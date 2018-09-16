package net.sjl.spring.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Question {
	
	@Id
	private long id;
	
	@Field("passageid")
	private int passageId;
	
	private String stem;
	private int order;
	private String analysis;
	private char rightAnswer;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPassageId() {
		return passageId;
	}
	public void setPassageId(int passageId) {
		this.passageId = passageId;
	}
	public String getStem() {
		return stem;
	}
	public void setStem(String stem) {
		this.stem = stem;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	public char getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(char rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

}
