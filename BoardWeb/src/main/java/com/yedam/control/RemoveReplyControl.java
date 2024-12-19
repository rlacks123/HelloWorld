package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;
             
public class RemoveReplyControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 댓글번호를 삭제.
		String rno = request.getParameter("rno");
		
		ReplyDAO rdao = new ReplyDAO();
		if (rdao.deleteReply(Integer.parseInt(rno))) {
			// {"retCode": "OK"}
			response.getWriter().print("{\"retCode\": \"OK\"}");
		}
		else {
			// {"retCode": "Fail"}
			response.getWriter().print("{\"retCode\": \"Fail\"}");
		}
	}
}
