package com.yedam.board;
/*
 *  회원아이디, 비밀번호, 이름, 연락처,
 */
public class Member {
	private String memberId;
	private String password;
	private String memberName;
	private String phoneNuber;
	
	// 생성자
	public Member(String memberId, String password, String memberName, String phoneNuber) {
		this.memberId = memberId;
		this.password = password;
		this.memberName = memberName;
		this.phoneNuber = phoneNuber;
	}
	
	// 메소드.
	public String showInfo( ) { // 
		return " " + memberId + " " + memberName + " " + phoneNuber;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getPassword() {
		return password;
	}
}
