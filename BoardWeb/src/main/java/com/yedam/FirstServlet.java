package com.yedam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.yedam.jdbc.BoardDAO;
import com.yedam.jdbc.BoardVO;

/**
 * Servlet implementation class FirstServlet
 */           //first
@WebServlet("/first") //http://localhost/BoardWeb/FirstServlet
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 컨태트타입 지정.
		System.out.println("doGet 요청");
		response.setContentType("text/html;charset=utf-8");
		// 출력스트림(자바에서는 데이터의 이동 스트림)
		PrintWriter out = response.getWriter(); 
		String boardNo = request.getParameter("board_no");
	
		BoardDAO bdao = new BoardDAO();
//		BoardVO board = bdao.selectBoard(Integer.parseInt(boardNo));
		BoardVO board = null;
		try { 
			board = bdao.selectBoard(Integer.parseInt(boardNo));
		} catch (Exception e) {
			out.print("게시글을 입력하세요");
			return;
		}
		
		out.print("<h3>상세페이지</h3>");
		if (board == null) {			
			out.print("<p>조회된 정보가 없습니다</p>");
		} else {
			String html = "<table border='1'>";
			html += "        <tr>";
			html += "          <th>글번호</th><td>" + board.getBoardNo() + "</td>";
			html += "          <th>제목</th><td>" + board.getTitle() + "</td>";
			html += "        </tr>";
			html += "        <tr>";
			html += "          <th>글내용</th><td>" + board.getContent() + "</td>";
			html += "        </tr>";
			html += "         <tr>";
			html += "          <th>작성자</th><td>" + board.getWriter() + "</td>";
			html += "          <th>작성일자</th><td>" + board.getCreationDate() + "</td>";
			html += "        </tr>";
			
			html += "      </table>";
			out.print(html);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("urf-8");
		response.setContentType("text/html;charset=utf-8");
		// 출력스트림(자바에서는 데이터의 이동 스트림)
		PrintWriter out = response.getWriter(); 

		// first?title=
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		// first?title=테스트&content=테스트내용&writer=user01
//		System.out.println("제목: " +title+", 내용: " + content + ", 작성자: "+writer);
		
		BoardDAO bdao = new BoardDAO();
		if (bdao.insertBoard(null)) {
			out.print("<p>등록됨</p>");
			out.print("<a href='second'>목록이동</a>");
		} else {
			out.print("<p>등록안됨</p>");
		}
	}

}
