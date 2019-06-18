package com.sc.springmvc.pojo;

import java.util.Date;

public class Examine {

	private Integer id;
	private String em_in;
	private String em_pwd;
	private String String;
	private Integer student;
	private String answer;
	private Integer score;
	private Integer paper_id;
	private Date em_date;
	private char status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEm_in() {
		return em_in;
	}
	public void setEm_in(String em_in) {
		this.em_in = em_in;
	}
	public String getEm_pwd() {
		return em_pwd;
	}
	public void setEm_pwd(String em_pwd) {
		this.em_pwd = em_pwd;
	}
	public String getString() {
		return String;
	}
	public void setString(String string) {
		String = string;
	}
	public Integer getStudent() {
		return student;
	}
	public void setStudent(Integer student) {
		this.student = student;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getPaper_id() {
		return paper_id;
	}
	public void setPaper_id(Integer paper_id) {
		this.paper_id = paper_id;
	}
	public Date getEm_date() {
		return em_date;
	}
	public void setEm_date(Date em_date) {
		this.em_date = em_date;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	
	
	
}
