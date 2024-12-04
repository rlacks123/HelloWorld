package com.yedam.api;

import java.util.Date;

public class StringTest {
	public static void main(String[] args) {
		byte[] bytes = "Hello".getBytes();
		System.out.println(new String(bytes));
		test1();
		test2();
		test3();
	}

	static void test1() {
		// 현재 시간을 yyyy/MM/dd hh:mm:ss 로 출력.
		Date now = new Date();
		answer1(now);
//		System.out.println("");

	}

	static void answer1(Date today) {
		String result = "%d/%d/%s %s:%s:%s";
		int yyyy = today.getYear() + 1900;
		int MM = today.getMonth() + 1;
		
		String dd = "0" + today.getDate();
		String hh = "0" + today.getHours();
		String mm = "0" + today.getMinutes();
		String ss = "0" + today.getSeconds();		
				
		System.out.println( yyyy // 년
				+ "/" + MM // 월
				+ "/" + dd.substring(dd.length() - 2) // 일
				+ "/" + hh.substring(hh.length() - 2) // 시
				+ "/" + mm.substring(mm.length() - 2) // 분
				+ "/" + ss.substring(ss.length() - 2)); //초
	}

	static void test2() {
		// 주민번호를 받아서 성별을 구별하는 프로그램.
		String[] numbers = { "9501231234567", "950405 2345678", "980102-1345678" };
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i] + "는" + answer2(numbers[i]) + "번호 는 남자입니다.");
						
		}
	}
	static String answer2(String ssn) {
		int pos = ssn.length() - 7; // 6 , 7
		char c1 = ssn.charAt(9);
		String result;
		switch(ssn.charAt(pos)) {
		case '1':
			result = "남";
			break;
		case '2':result = "여";	
		    break;
		default:result = "알수없음";
		    break;
		}
//		case '1':
//			return "남자";
//		case '2':
//			return "여자";
//		default
//			return "알수없음";
		return result;
	}

	static void test3() {
		// 파일의 이름과 확장자를 구하는 코드.
		String[] files = { "c:/temp/rose.jpg", "d:/download/new.txt", "temp/good.jpeg" };
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i] + "의 파일명은" + answer3(files[i]) + " 입니다.");
		}
	}

	static String answer3(String name) {
		int endPos = name.indexOf("."); // .기준으로 찾기
		int startPos = name.lastIndexOf("/"); // /기준으로 찾기
		String ext = name.substring(startPos + 1, endPos);
		return ext;

	}
}
