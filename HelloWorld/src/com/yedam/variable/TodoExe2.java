package com.yedam.variable;

import java.util.Scanner;

public class TodoExe2 {
	public static void main(String[] args) {
		String name = "김길동"; // 
		
		Scanner scn = new Scanner(System.in); // 스캐너
		System.out.println("이름을 입력.");
		String inputValue = scn.nextLine(); //사용자의 입력값을 반환
//		System.out.println("입력한 값은" + inputValue);
		
		if(name.equals (inputValue)) {
		System.out.println("같은 이름입니다"); // 같은이름. 다른이름.
		} else {
			System.out.println("다른 이름입니다");	
		}
		
		System.out.println("end of prog");
	}
}
