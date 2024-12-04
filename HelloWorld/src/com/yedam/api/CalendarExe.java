package com.yedam.api;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance(); // 인스턴스 생성.
//		System.out.print(cal.toString()); // 다향한 정보를 담고있음
		cal.set(2024, 1, 1); // 
//		System.out.print(Calendar.YEAR + ","+ cal.get(1)); //년 정보
//		System.out.print(Calendar.MONTH + ","+ cal.get(Calendar.MONTH)); //월 정보
//		System.out.print(cal.get(Calendar.DAY_OF_WEEK)); //일 정보
		System.out.print(cal.get(Calendar.DAY_OF_WEEK) + "요일"); // 요일정보
		System.out.print(cal.getActualMaximum(Calendar.DATE) + "막날"); // 마지막날 정보
		
//		createCalendar(6, 30); // 11월 1일부터 31일까지 있는거 넣음 12월은 1일이 6번째 시작이라 이렇게함
		createCalendar(2024, 11);
		
	}
	
	// 1일의 요일?, 막날? 알면 => 달력. 만들수있음
//	static void createCalendar(int positionOfDay, int lastDate) {
	static void createCalendar(int year, int month) { // 활용해서 년월일 달력 만들어보기
		int positionOfDay = 0; //계산
		int lastDate = 0; //계산.
		String[] days = {"Sum", "Mon", "Tue", "Wer", "Thr", "Fri", "Sat"};
		for (String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		// 1일의 위치지정.
		for(int i=1; i<positionOfDay; i++) {
			System.out.printf("%4s", " ");
		}
		// 날짜출력.
		for (int d = 1; d <= 31; d++) {
			System.out.printf("%4s", d);
//			if(d % 7 == 0) {
			if((d + positionOfDay -1 ) % 7 ==0) { // positionOfDay 기준으로 금요일부터 1일 시작
				System.out.println(); // 줄바꿈 31일 7일 간격으로
			}
		}
	}
	
}

//System.out.println();
//// 1일의 위치지정.
//for(int i=1; i<positionOfDay; i++) {
//	System.out.printf("%4s", " ");
//}
//// 날짜출력.
//for (int d = 1; d <= 31; d++) {
//	System.out.printf("%4s", d);
////	if(d % 7 == 0) {
//	if((d + positionOfDay -1 ) % 7 ==0) { // positionOfDay 기준으로 금요일부터 1일 시작
//		System.out.println(); // 줄바꿈 31일 7일 간격으로