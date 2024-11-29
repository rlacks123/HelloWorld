package com.yedam.variable;

public class TodoExe1 {
	public static void main(String[] args) {
		// Math.random() : 0 ~ 1 임의의 실수.
		// 1 ~ 100까지의 임의의 수 3번 생성
		// 3개변수 합. 강제형변환( (int) 3.1 )
//		randomValue
		int sum = 0;
		for (int i=0; i < 3; i++ ) {
//			System.out.println((int)(Math.random()*100)+1);
			int randomValue = (int) (Math.random() *100)+1;
			sum += randomValue; // randomValue 네임은 암거나 해도됨
		}	
		System.out.println(sum);
	}
}
