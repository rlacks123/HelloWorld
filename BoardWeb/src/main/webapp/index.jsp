<%@page import="com.yedam.jdbc.BoardDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
 // 주석처리.
 String msg = "Hello";
 System.out.println(msg);
 %>
 <p>변수에 담긴 값은 <%=msg %></p>
 
 <%
 BoardDAO bdao = new BoardDAO();
 List<BoardVO> list = bdao.boardList();
 
 for (BoardVO board : list) {
 %>	 
<p> 글번호:<%=board.getBoardNo() %> 제목:<%=board.getTitle() %>
    작성자:<%=board.getContent() %></p> 
<%  }%>

</body>
</html>