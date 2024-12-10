package com.yedam.common;
/*
 * 인터페이스는 구현클래스를 통해 실제 기능이 정의.
 * 인퍼페이스는 규칙만 제시.
 */

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Control {
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException; // 메소드의 선언만 있는 메소들를 추상메소드.
}
