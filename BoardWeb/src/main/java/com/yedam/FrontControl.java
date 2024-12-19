package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.AddEventControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardFormControl;
import com.yedam.control.BoardListControl;
//import com.yedam.control.CalendarDataContro;
import com.yedam.control.CalendarDataControl;
import com.yedam.control.ChartControl;
import com.yedam.control.ChartDataControl;
import com.yedam.control.GetReplyCountControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyFormControl;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.ReplyListControl;
//import com.yedam.control.fullCalendarContro;
import com.yedam.control.fullCalendarControl;

/*
 * url pattern에서 *.do => FrontControl을 반환
 */
public class FrontControl extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Map<String, Control> map;
	public FrontControl() {
		map = new HashMap<>();	// 필드의 값을 초기화
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/boardList.do", new BoardListControl());	// 목록보기
		map.put("/board.do", new BoardControl());	// 상세보기
		// 게시물 등록
		map.put("/boardForm.do", new BoardFormControl());
		// 게시물 수정
		map.put("/modifyForm.do", new ModifyFormControl());
		map.put("/modifyBoard.do", new ModifyBoardControl());
		// 로그인 화면
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		// 로그아웃.
		map.put("/logout.do", new LogoutControl());
		// 댓글.
		map.put("/replyList.do", new ReplyListControl()); // 댓글목록.
		map.put("/addReply.do", new AddReplyControl()); // 댓글삭제.
		map.put("/removeReply.do", new RemoveReplyControl()); // 댓글삭제.
		map.put("/getConut.do", new GetReplyCountControl());
		
		// 구글 차트.
		map.put("/chart.do", new ChartControl());
		map.put("/chartData.do", new ChartDataControl());
		
		// fullcalendar
		map.put("/full.do", new fullCalendarControl());
		map.put("/fullData.do", new CalendarDataControl());
		map.put("/addEvent.do", new AddEventControl());
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:80/BoardWeb/hello.do
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path);
		
		// 요청url === 실행할 컨트롤
		Control control = map.get(path);
		control.exec(request, response);
	}
}
