package com.yedam.Jdbc.student;

import java.sql.Date;

//import java.sql.Date;

public class Student {
	private String stdNo;
	private String stdName;
	private String stdPhone;
	private int engScore;
	private int mathScore;
//	private String cerationDate;
	private Date creationDate;
//	private String memberId;
//	private String password;

	
	
//	public String getMemberId() {
//		return memberId;
//	}
//
//
//
//	public void setMemberId(String memberId) {
//		this.memberId = memberId;
//	}
//
//
//
//	public String getPassword() {
//		return password;
//	}
//
//
//
//	public void setPassword(String password) {
//		this.password = password;
//	}



	public String getStdNo() {
		return stdNo;
	}



	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}



	public String getStdName() {
		return stdName;
	}



	public void setStdName(String stdName) {
		this.stdName = stdName;
	}



	public String getStdPhone() {
		return stdPhone;
	}



	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}



	public int getEngScore() {
		return engScore;
	}



	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}



	public int getMathScore() {
		return mathScore;
	}



	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}



	public Date getCreationDate() {
		return creationDate;
	}



	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public char[] showDetail() {
		// TODO Auto-generated method stub
		return null;
	}


	//목록으로 출력.
	public String showInfo() {
		return stdNo + " " + stdName + " " + stdPhone + " " + engScore + " " + " " + mathScore;
	}










}
