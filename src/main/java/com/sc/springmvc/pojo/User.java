package com.sc.springmvc.pojo;

public class User {

	private Integer user_id;
	private String user_name;
	private String login_name;
	private String password;
	private char user_type;
	private char sts;
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getUser_type() {
		return user_type;
	}
	public void setUser_type(char user_type) {
		this.user_type = user_type;
	}
	public char getSts() {
		return sts;
	}
	public void setSts(char sts) {
		this.sts = sts;
	}
	
}
