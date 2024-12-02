package com.yedam.methods;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student("S001");
		Student s2 = new Student("S002");
		
//		s1.engScore = 1000;
		s1.setStdName("홍길동");
		s1.setEngScore(70);
		s1.setMathScore(75);
		
		s2.setStdName("고길동");
		s2.setEngScore(99);
		s2.setMathScore(98);
		
		System.out.println(s1.showInfo());
		System.out.println(s2.showInfo());
		
	}
}
