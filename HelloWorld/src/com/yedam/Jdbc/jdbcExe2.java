package com.yedam.Jdbc;

import java.sql.Statement; // sql로 하는거 중요 java로 하면 연결안됨
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 *  JDBC 프로그램
 *  1. 드라이브 로드.
 *  2. database 데이터베이스 연결 (connection) 커넥션
 *  3. query 쿼리 실행
 *  4. 실행된 결과 -> 화면 출력.
 *  5. database close.
 */
public class jdbcExe2 {
	public static void main(String[] args) {
//		insert("Park", "2020-02-02","AD_PRES","skjsd");
//		update();
//		deLete();
		Employee emp = new Employee();
		emp.setLastName("Park");
		emp.setHireDate("2001-01-01");
//		emp.setEmployeeId(214);
//		
//		deLete(emp.getEmployeeId());
		select();
		
		System.out.println("end of Prog");
   }
// 삭제기능.
	public static void delete(int id) {
		
	}
	
//수정 기능.
	public static void update(Employee emp) {
		Connection conn = getConn();
		String query = "update employees " //
				+ "       set first_name = ?" //
				+ "           ,phone_number = ?" //
				+ "           ,salary = ?" //sal
				+ "       where employee_id = ?"; //empid
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, emp.getFirstName());
			stmt.setString(2, emp.getPhoneNumber());
			stmt.setString(3, emp.getSalary());
			stmt.setString(4, emp.getEmployeeId());
			
			int r = stmt.executeUpdate(query);
			System.out.println(r + "건 처리됨.");
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 입력기능.
	public static void insert(Employee emp) {	
		Connection conn = getConn();
		String query = "insert into employees(employee_id "
				+ "                             , last_name "//
				+ "                             , email "//
				+ "                             , hire_date "//
				+ "                             , job_id ) "//
				+ "values(employees_seq.nextval"  // empId
				+ "     , ? " // last_name
				+ "     , ?"    // email
				+ "     , ?"     //hire_date
				+ "     , ? )";
		try {
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, emp.getLastName());
		stmt.setString(2, emp.getEmail());
		stmt.setString(3, emp.getHireDate());
		stmt.setString(4, emp.getJobId());
		
		int r = stmt.executeUpdate(query);
		System.out.println(r + "건 처리됨.");
		conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 연결.
	public static Connection getConn() {
		Connection conn = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드.
				// Connection 객체.
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
				return conn;
			
			} catch (Exception e) {
				System.out.println("연결중 에러 ");
				e.printStackTrace();
			}
			return conn; // connection 객체 반환.
	}
	
	
	// 조회기능.
	public static void select() {
		Connection conn = getConn();
		
		// sql작성 Statement 객체.
		ResultSet rs;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from employees order by employee_id desc");
			
			while(rs.next()) { // sql에서 가져올 정보들
				System.out.println(rs.getInt("employee_id") + ", "//
						+ rs.getString("first_name") + ", "//
//						+ rs.getString("hire_date") + ", "//
						+ rs.getString("last_name") + ", "
						+ rs.getString("salary") + ", "
						+ rs.getString("phone_number") + ", "
//						+ rs.getString("job_id") + ", " //
						+ rs.getString("email"));
			}
			conn.close(); // 연결해제.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 조회.
		
		System.out.println("== end of data");
	}
}
