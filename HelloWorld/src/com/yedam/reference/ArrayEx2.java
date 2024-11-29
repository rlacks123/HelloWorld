package com.yedam.reference;
import java.util.Scanner;

/*
 *  은행 프로그램 v1.0
 *  작성자: 김예찬
 *  작성일시: 2024.11.29
 */

public class ArrayEx2 {
	public static void main(String[] args) {
		// 변수 초기화, 10만원 초과불가.  -잔고 불가
		// : 90000원에서 20000원 입금안됨.
		boolean run = true; // 불린 츄르 설정
		int balance = 0; //밸런스 변수 선언
		int maxBalance = 100000; // 최대금액.
		Scanner scn = new Scanner(System.in); // 스캐너 선언
		
		while(run) {
			System.out.println("-------------------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료    ");
			System.out.println("-------------------------");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine()); // 1,2 넥스트 라인 선언
			
			
			switch(menu) {
			case 1:
				System.out.print("예금액> " ); // 현재잔고 + 예금액 <= 100000 인 경우 정상예금처리.
				int inBalance = Integer.parseInt(scn.nextLine());
				if ( balance + inBalance <= maxBalance) {
					 balance += inBalance;
				} else {
					System.out.print("금액초과입니다 ");
				}
				break; // 브레이크 설정 
			case 2:
				System.out.print("출금액> ");
				// 현재 잔고 - 출금액 > 0인 경우 정상출금처리.
				inBalance = Integer.parseInt(scn.nextLine());
				if ( balance - inBalance > 0) {
					 balance -= inBalance;
				} else {
					System.out.print("금액초과입니다 ");
				}
				break; // 브레이크 설정
			case 3:
				System.out.print("잔고> " + balance);
				break;
			case 4:
				run = false;
			} 
			
		}
		System.out.println("프로그램 종료");
	}
	
}
