package com.yedam.Jdbc.student;

//import java.sql.Date;

public class Student {
	private String stdNo;
	private String stdName;
	private String stdPhone;
	private String engScore;
	private String mathScore;
	private String cerationDate;
	public Student() {
		
	}
	
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

	public String getEngScore() {
		return engScore;
	}

	public void setEngScore(String engScore) {
		this.engScore = engScore;
	}

	public String getMathScore() {
		return mathScore;
	}

	public void setMathScore(String mathScore) {
		this.mathScore = mathScore;
	}

	public String getCerationDate() {
		return cerationDate;
	}

	public void setCerationDate(String cerationDate) {
		this.cerationDate = cerationDate;
	}

	//목록으로 출력.
	public String showInfo() {
		return stdNo + " " + stdName + " " + stdPhone;
	}

}
