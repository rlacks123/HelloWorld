package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.yedam.jdbc.BoardDAO;
import com.yedam.jdbc.BoardVO;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// 1. HttpServlet 상속.
// 2. 생성자 정의
// 3. init 메소드 실행.
// 4. service 메소드 실행.

@WebServlet("/second2") // 똑같은 url 두개 실행되면 안됨 이름 바꾸던가 하난 주석처리
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
	public SecondServlet() {
		System.out.println("SecondServlet 생성자 호출");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 호출");
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		BoardDAO bdao = new BoardDAO();
		List<BoardVO> list = bdao.boardList();
		
		out.print("<h3>게시글 목록</h3>");
		out.print("<table border='2'>");
		out.print("<thead><tr><th>글번호</th><th>제목</th><th>작성자</th><th>조회수</th></tr></thead>");
		out.print("<tbody>");
		// 반복.
		for(BoardVO brd : list) {
			out.print("<tr><td><a href='first?board_no=" + brd.getBoardNo> + brd.getBoardNo() + "</td>");
			out.print("<td>" + brd.getTitle() + "</td>");
			out.print("<td>" + brd.getWriter() + "</td>");
			out.print("<td>" + brd.getView_cnt() + "</td></tr>");
			
		}
		out.print("</tbody>");
		out.print("</table>");
	}
}
