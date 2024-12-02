package com.yedam.classes;

import com.yedam.student.Student;

public class CalculatorExe {
	public static void main(String[] args) {
		Calculator cali = new Calculator(); // 인스턴스 생성.
		int sum = cali.sum(10,20);
		
		System.out.println("합계: " + cali.sum(10, 20));
		System.out.println("합계: " + cali.sum(10.3, 20));
		System.out.println("큰값은 " + cali.max(30, 20.2));
		cali.printStar(3);
		
		
		
		int[] intAry = {3, 6, 9, 12};
		sum = cali.sumAry(intAry); // 리턴값 int , 매개변수 정수배열;
		System.out.println("intAry의 합계 " + sum);
		
		double result = cali.averageAry(intAry); // 평균 구하기 에버리지어레이
		System.out.println("intAry의 평균 " + result);
		
		Student s1 = new Student("S001", "홍길동", 83, 78);
		Student s2 = new Student("S002", "김길동", 77, 83);
		Student s3 = new Student("S003", "최길동", 88, 91);
		
		Student[] stdAry = {s1, s2, s3};
		Student std = cali.getMaxScore(stdAry);
//		System.out.println("최고영어점수는 " + cali.getMaxScore(stdAry));
		System.out.println("최고영어점수는 " + std.engScore + ", 이름은" + std.stdName);
		
	}
}
