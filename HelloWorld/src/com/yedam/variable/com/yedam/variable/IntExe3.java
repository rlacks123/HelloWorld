package com.yedam.variable;

public class IntExe3 {
	public static void main(String[] args) {
		boolean b1 = true;
		b1 = 10 > 20;
		
		char c1 = 0; // ascii아스키가 unicode유니코드 코드값을 숫자에 매핑시킴
		c1 = 65; // 'A'; 를 써도 같은 의미
		for (int i = 1; i <= 26; i++) {
		System.out.println(c1++);
		}
		char c2 = '궵'; // "Hello" 비교.
		System.out.println((int) c2);
		
		//
		double n1 = 1;
//		int n1 = 1;
		int n2 = 2;
		double result4 = n1 *1.0 / n2; // 자동형변환(promotion). 0.5 => 0 안하면
		
		System.out.println("n1 / n2 의 결과" + result4);
		// byte < short < int << long < float < double 바이트 작은 순서및 형변환
	}
}
