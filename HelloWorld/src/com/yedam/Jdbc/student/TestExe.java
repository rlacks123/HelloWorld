package com.yedam.Jdbc.student;

import java.util.ArrayList;

public class TestExe {
	public static void main(String[] args) {
		// 검색조건.
		Search search = new Search();
		search.setName("");
		search.setPhone("22");
		search.setEngScore(80); // 60점 이상.
		search.setOrderBy("std_no"); // 학생번호 정렬.
		
		StudentDAO sdao = new StudentDAO();
		ArrayList<Student> list = sdao.studentList(search);
		for(Student std : list) {
			System.out.println(std.showInfo());
		}
	}

}
