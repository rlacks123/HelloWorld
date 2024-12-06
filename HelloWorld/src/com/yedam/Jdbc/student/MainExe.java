package com.yedam.Jdbc.student;

import java.util.ArrayList;
import java.util.Scanner;

//import com.yedam.student.Student;

public class MainExe {
	
	static Scanner scn = new Scanner(System.in);
	
	// db 처리기능.
	static StudentDAO dao = new StudentDAO();
	
	public static void main(String[] args) {
		boolean run = true;
		
		// 로그인 기능. code here...
		// 게시판 관련. 로그인
//		String id, pw;
		
		while(true) {
		System.out.print("회원아이디>> ");
		String id = scn.nextLine();
		System.out.print("회원비밀번호>> ");
		String pass = scn.nextLine();
		// 로그인매소드 호출 login()
		String name = dao.login(id, pass);
		if(name != null) { 
			System.out.println(name+"로그인성공");
		} else {
			System.out.println("다시 로그인하세요.");
		}
		break;
		}
		
		while(run) {
			System.out.println("1.목록 2.등록 3.점수등록 4.상세조회 9.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {

			case 1: // 학생 목록 출력
				list();
                break;
			
			case 2: // 등록.
				System.out.print("학생번호 입력>> ");
				String no = scn.nextLine();
				System.out.print("학생이름 입력>> ");
				String name = scn.nextLine();
				System.out.print("연락처 입력>> ");
				String phone = scn.nextLine();
				
//				Student std = new Student(no, name, phone);
				
				Student std = new Student();
				std.setStdNo(no);
				std.setStdName(name);
				std.setStdPhone(phone);
				
				if(dao.insertSrudent(std)) {
					System.out.println("정상 등록.");
				} else {
					System.out.println("등록 실패.");
				}
				break;
				
			case 3: // 점수 등록
//				Student stdx = new Student(scn, escore, mscore);
				System.out.println("학생번호 입력>> ");
				no = scn.nextLine();
				System.out.println("영어점수 입력>> ");
				int escore = Integer.parseInt(scn.nextLine());
				System.out.println("수학점수 입력>> ");
				int mscore = Integer.parseInt(scn.nextLine());
				
				std = new Student();
				std.setStdNo(no);
				std.setEngScore(escore);
				std.setMathScore(mscore);

                if (dao.updateStudent(std)) {
                    System.out.println("점수등록 완료.");
                } else {
                    System.out.println("점수등록 실패.");
                }
                break;
				
			case 4: // 상세조회.
				System.out.print("학생번호 입력>> ");
				no = scn.nextLine();
				
				std = dao.selectStudent(no); //Student 값 반환
				if(std == null) {
					System.out.println("조회된 결과 없습니다.");
					break;
				}
				System.out.println(std.showDetail()); // 상세출력.
				break;
				
			case 9: // 종료.
				run = false;
//				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");
	} // end of main.
	// 목록기능.
	public static void list() {
		Search search = new Search();
		
		System.out.println("1.학생이름 2.연락처 3.영어점수");
		System.out.print("선택>> ");
		int menu = Integer.parseInt(scn.nextLine());
		
		switch(menu) {
		case 1:
			System.out.print("검색할 이름>>");
			String name = scn.nextLine();
			search.setName(name);			
		     break;
		case 2:
			System.out.print("검색할 연락처>>");
			String phone = scn.nextLine();
			search.setPhone(phone);
			break;
		case 3:
			System.out.print("검색할 영어점수>>");
			int escore = Integer.parseInt(scn.nextLine());
			search.setEngScore(escore);
			break;
       } // end of switch.
		
		System.out.println("1.학생번호정렬 2.학생이름정렬 ");
		System.out.print("선택>> ");
		int orderBy = Integer.parseInt(scn.nextLine());
		// 정렬조건 추가. ordeBy => 값을 ? 지정.
		// 완성...
		
//		switch (orderBy) {
//		case 1:
//			search.setOrderBy("std_no");
//			break;
//		case 2:
//			search.setOrderBy("std_name");
//			break;
//		}
//		
//		ArrayList<String> stdNoList = dao.studentList(search);
//		System.out.println("학생번호 이름");
//		for (String stdNo : stdNoList) { // 학생번호, 이름, 연락처
//			Student std = dao.selectStudent(stdNo);
//			if (std == null)
//				continue;
//			System.out.println(std.showInfo());
		
		ArrayList<Student> list = dao.studentList(search); // DAO에서 학생 목록 조회
		for (Student stud : list) { // 학생번호, 이름, 연락처, 영어, 생성일.
			System.out.println(stud.showInfo()); 
			break;
		}
		
	} // end of list().
	
}
