package com.test.dto;

public class AuthDto {
	private String email;
	private String grade;
	
	
	public AuthDto() {}
	//default 생성자
	public AuthDto(String email, String grade) {
		super();
		this.email = email;
		this.grade = grade;
	}

	//getter and setter
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	//toString
	@Override
	public String toString() {
		return "AuthDto [email=" + email + ", grade=" + grade + "]";
	}
	
}
