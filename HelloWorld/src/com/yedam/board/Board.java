package com.yedam.board;

import java.util.Date;

/*
 *  게시글 번호, 제목, 내용, 작성자, 등록일시
 * 
 */

public class Board {
	private int boardNo; // 게시글 번호.
	private String title; // 제목.
	private String content; // 내용.
	private String writer; //작성자(회원아이디)
//	private String writeDate; //등록일시.
	private Date writeDate; //등록일시.
	
	// 생성자.
	public Board() { // 퍼블릭 보어드
		
	}
	
	public Board(int boardNo, String title, String content, String writer, Date writeDate) {
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
	}
	
	// getter. setter 겟 셋 메소드
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getBoardNo() {
		return boardNo; // 겟 메소드는 가져오는거라 리턴해줘야함
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getcontent() {
		return content;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getwriter() {
		return writer;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public String showInfo() { // 목록보여줄 메소드
		String yyyymmdd = (writeDate.getYear() + 1900) + "년 " 
		        + (writeDate.getMonth() + 1) + "월 " 
		        + writeDate.getDate() + "일";
		return " " + boardNo + " " + title + " " + writer + " " + yyyymmdd;
	}

}
