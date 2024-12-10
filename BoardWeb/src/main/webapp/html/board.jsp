<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../incLudes/header.jsp"></jsp:include>


 <!--  board.jsp 원래있던 부분. -->
  <h3>글상세화면(board.jsp)</h3>
  <%
  BoardVO bvo = (BoardVO) request.getAttribute("board");
  %>
  <table class="table">
    <thead>
    <tr>
	     <th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th>
	  </tr>
	 </thead>
	   <tbody>
	   <tr>
	     <td align="center"><%=bvo.getBoardNo()%>"></td>
	     <td><%=bvo.getTitle() %></td>
	     <td><%=bvo.getWriter() %></td>
	     <td><%=bvo.getCreationDate() %></td>
	   </tr>
    <tr>
      <th colspan="4">내용</th>
    </tr>
    <tr>
      <td colspan="4"><%=bvo.getContent() %></td>
    </tr>
   </tbody>
  </table>
 
<jsp:include page="../incLudes/footer.jsp"></jsp:include>