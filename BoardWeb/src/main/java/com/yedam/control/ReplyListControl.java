package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		String bno = request.getParameter("bno");
		String page = request.getParameter("page");
//				!= null ? request.getParameter("page") : "1";
		// 댓글 -> 자바스크립트 object -> json 문자열
		if (page == null);
		    page ="1";
		// 형식 : {문자열or숫자:문자열or숫자, 문자열or숫자:문자열or숫자, ...}
		ReplyDAO rdao = new ReplyDAO();
		List<ReplyVO> list = rdao.selectList(Integer.parseInt(bno),Integer.parseInt(page));
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);

		

		response.getWriter().print(json);
	}
}
