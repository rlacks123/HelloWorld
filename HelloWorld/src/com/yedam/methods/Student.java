package com.yedam.methods;

/*
 * 학생의 성적관리 Prog.
 * 학생번호, 학생이름, 영어점수, 수학점수
 * 
 */
public class Student {
	
	private String stdNo; // 자바에선 속성과 동작을 필드라고함
	private String stdName;
	private int engScore;
	private int mathScore;
	
	// 생성자.
	public Student(String stdNo) {
		this.stdNo = stdNo;
	}
	
	public Student(String stdNo, String stdName, int engScore, int mathScore) {
		super();
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	// getter, setter. 겟메소드, 셋메소드

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
	//showInfo()
	public String showInfo() {
		return "학번: " + stdNo + ", 이름: "+ stdName + ", 영어점수: "+ engScore +", 수학점수: " + mathScore ;
	}

}

