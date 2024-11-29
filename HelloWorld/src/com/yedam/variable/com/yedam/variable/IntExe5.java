package com.yedam.variable;

public class IntExe5 {
	public static void main(String[] args) {
		// 정수형 => byte(1바이트), short(2바이트), int(4바이트),
		// long(8바이트), char(2바이트)
		// 1비트 * 8 => 1바이트.
		byte b1 = 100;
		byte b2 = 100;
		int result = (int) b1 + (int) b2; // 형변환(casting)

		byte result2 = (byte) (b1 + b2);
		System.out.println(result2);

		for (int i = 0; i < 100; i++) {
			System.out.println("b1의 값:" + ++b1);
		}
		System.out.println(2147483647);
		long l1 = 10000000000l; // 0이 너무많으면 오류 l 써줌

		// float(4바이트), double(8바이트)
		// 0 ~ 1 사이의 모든 값을 표현못함 근사치로 계산됨
		double d1 = 0.1;
		double d2 = 0.2;
		double result3 = d1 + d2;
		result3 = 0.345678;
		
		// 소숫점 보려는 계산
		System.out.println("result3 값:" + Math.floor(result3 *1000) / 1000);

		// doubleAry의 합은 78.4 입니다.
		double[] doubleAry = {10, 23.4, 11.7, 34.5};
		double sum = doubleAry[0] + doubleAry[1] + doubleAry[2] + doubleAry[3];

//		double sum = 0;
//		for (int i = 0; i < 4; i++) {
//			sum += doubleAry[i];
//		}
//		//다른방법
//		double doubleSum = 0;
//		for (int i = 0; i < doubleAry.length; i++);
//		doubleSum += doubleAry[i];
		
		System.out.println("doubleAry의 값:" + sum);
	}
}
