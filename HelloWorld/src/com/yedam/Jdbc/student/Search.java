package com.yedam.Jdbc.student;
/* 서치
 * 이름, 연락처, 영어, 수학, 정렬조건 포함한 클래스
 */
public class Search {
	// 필드.
	private String name;
	private String phone;
	private int engScore;
	private int mathScore;
//	private String engScore;
//	private String mathScore;
	private String orderBy = "std_no";
	
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
//	public String getEngScore() {
//		return engScore;
//	}
//	public void setEngScore(String engScore) {
//		this.engScore = engScore;
//	}
//	public String getMathScore() {
//		return mathScore;
//	}
//	public void setMathScore(String mathScore) {
//		this.mathScore = mathScore;
//	}
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
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	
}
