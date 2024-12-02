package com.yedam.student;

/*
 * 학생의 성적관리 Prog.
 * 학생번호, 학생이름, 영어점수, 수학점수
 * 
 */
public class Student {
	public String stdNo; // 자바에선 속성과 동작을 필드라고함
	public String stdName;
	public int engScore;
	public int mathScore;
	
	// 컴파일러 기본 생성자를 만들어준다.
//	public Student() {  }
	public Student() {  }
	
	public Student(String stdNo) {
		this.stdNo = stdNo; // 디스 사용
	}
	
	public Student(String stdNo, String stdName) {
		this.stdNo = stdNo;
		this.stdName = stdName;
	}
	
	public Student(String stdNo, String stdName, int engScore, int mathScore) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}
	
	// 메소드.
	public void smile() {
		System.out.println("학생이 웃습니다."); // 동작
	}
	public void introduce() {
		System.out.println("이름은 " + stdName + "이고 학번은 " + stdNo); // 속성
	}
	
	public int sumScore() {
		return engScore + mathScore;
	}
	
	// 평균을 반환하는 메소드: average(){} 더블타입
	public double average () {
		return sumScore() / 2.0;
	}
}
