package com.yedam.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.jdbc.ReplyDAO;

public class CalendarDataControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// fullcalendar data => json 출력.
		response.setContentType("text/json;charset=utf-8");
		
		ReplyDAO rdao = new ReplyDAO();
		List<Map<String, Object>> list = rdao.calendarData();

		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));
	}
}
