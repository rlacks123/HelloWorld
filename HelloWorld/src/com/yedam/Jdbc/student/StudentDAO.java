package com.yedam.Jdbc.student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/*
 *  tbl_stubent의 칼럼을 필드로 선언.
 *  std_no => stdNo;
 *  DAO: Data Access Object
 *  입력, 수정, 삭제, 조회(목록, 단건)
 */
public class StudentDAO extends DAO {
	
	// login() => 반환:boolean, 매개값: id, password
	public String login(String id, String pw) {
	getConn();
	String sql =  "select * from tbl_member " //
			+ "    where member_id = ? "//
			+ "    and   password = ? "; //
	
	try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id); 
		psmt.setString(2, pw); 
		rs = psmt.executeQuery(); 
	    while (rs.next()) {
		   return rs.getString("member_name"); //조회결과가 있을 경우에는 true.
	    }	
	} catch (SQLException e) {
		e.printStackTrace();	
	} finally {
		disConnect(); // 연결해제
	}
	return null; // 조회된 결과가 없을 경우는 null.
		
}
	
	// 상세조회
	// 반환: Student클래스, 매개:학생번호, 메소드: selectStudent
	public Student selectStudent(String sno) {
		getConn();
		String sql = "select * "
				+ "from tbl_student "
				+ "where std_no = ?";
		
	try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1,  sno); // 파라미터(?) 값 지정
//		return null;
		while (rs.next()) {
			Student std = new Student(); // 인스턴스 생성
			std.setStdNo(rs.getString("std_no")); // 번호
			std.setStdName(rs.getString("std_name")); // 이름
			return std; // 조회결과 반환사고 메소드 종료.
		}
			
		
		
	   } catch (SQLException e) {
		e.printStackTrace();	
	} finally {
		disConnect(); // 연결해제
	}
		return null;
	}
	// 목록 출력
	public String showInfo() {
		// Date => 출력포맷.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh24:mi:ss");
		String cdate = sdf.format(creationDate); //cerationDate
		
		return " " + stdNo + " " stdName + " "//
				+ stdPhone + " " engScore + " " + mathScore + " ";
	}
	// 상세화면 출력.
	public String showDetail() {
//		----------------------------
//		학생번호: 24-001   이름: 홍길동
//		연락처: 010-1111-2222
//		영어점수: 80       수학점수: 70
//		----------------------------
		String result = "----------------------------\n";
		result += "학생번호: " + stdNo + "   이름: " + stdName + "\n";
		result += "연락처: " + stdPhone + "\n";
		result += "영어점수: " + engScore + "       수학점수: " + mathScore + "\n";
		result += "----------------------------\n";
		return result;
	}
 
	

	//점수 등록
	//반환:boolean, 매개:Student, 메소드:updateSrudent.
	public boolean updateStudent(Student upd) {
		getConn();
		String upd1 =  "update tbl_student "
				+ "        set eng_score = ? "//
				+ "        math_score = ? " //
				+ "     where std_no = ? ";
		
		try {
			psmt = conn.prepareStatement(upd1);
			psmt.setString(3, upd.getStdNo()); // std_no
			psmt.setInt(1, upd.getEngScore()); // std_name
			psmt.setInt(2, upd.getMathScore()); // std_phone
			int r = psmt.executeUpdate(); // 쿼리실행
		if(r > 0) {
			return true; //정상등록
		}
		
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			disConnect(); // 연결해제
		}
		return false;
		
		
		
	}
	
	// 등록. 반환값:boolean, 매개:Student, 메소드:insertSrudent.
	public boolean insertSrudent(Student std) {
		getConn();
		String sql =  "insert into tbl_student (std_no" //
				+"                              ,std_name"//
				+"                              ,std_phone)"
				+"   values(?,?,?)";
//		String sql = "update tbl_student";
		
		try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, std.getStdNo()); // std_no
		psmt.setString(2, std.getStdName()); // std_name
		psmt.setString(3, std.getStdPhone()); // std_phone
		int r = psmt.executeUpdate(); // 쿼리실행
		if(r > 0) {
			return true; //정상등록
		}
		
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			disConnect(); // 연결해제
		}
		return false;
	}
	
	// 학생목록
	// 검색조건(학생이름, 연락처, 영어, 수학 검색조건 + 정렬 조건.)
	public ArrayList<Student> studentList(Search search) {
	 getConn();
		//조회결과를 반환.
	 ArrayList<Student> studList = new ArrayList<Student>();
		
	 String sql = "select   std_no"
	 		+ "           , std_name"
	 		+ "           , std_phone"
	 		+ "           , eng_score"
	 		+ "           , math_score"
//	 		+ "           , to_char(creation_date, 'yyyy-mm-dd hh24:mi:ss') creation_date" //
	 		+ "           , creation_date " //
	 		+ "from tbl+student" //
	 		+ "where std_name like '%'||?||'%'  " // sql문 검색때 안에 연결연산자 써야함
	 		+ "and eng_score >= ? ";
//	 		+ "order by std_no";
	 
	 		if(search.getOrderBy().equals("std_no")) {
	 			sql +=  " order by std_no";
	 		}else if (search.getOrderBy().equals("std_name")) {
	 			sql +=  " order by std_name";
	 		}
	 				
	 try {
		psmt = conn.prepareStatement(sql); // 쿼리 실행, 결과 반환.
		psmt.setString(1,  search.getName());
		psmt.setInt(2, search.getEngScore());
		
		rs = psmt.executeQuery();
		// 반복 ArrayList에 담는 작업.
		while(rs.next()) {
			Student stud = new Student(); // 목록 조회때 나오는 항목 (중요)
			stud.setStdNo(rs.getString("std_no"));
			stud.setStdName(rs.getString("std_name"));
			stud.setStdPhone(rs.getString("std_phone"));
			stud.setEngScore(rs.getInt("eng_score"));
//			stud.setMathScore(rs.getInt("math_score"));
//			stud.setCerationDate(rs.getString("cdate")); //cdate
			stud.setCreationDate(rs.getDate("creation_date")); //cdate
			
			studList.add(stud); // ArrayList에 추가.
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		disConnect(); // 연결해제.
	}
	 //반환값.
	return studList;
  }
}

