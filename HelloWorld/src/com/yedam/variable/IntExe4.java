package com.yedam.variable;

public class IntExe4 {
	public static void main(String[] args) {
		String msg = new String ("Hello, World"); // msg 주소값에 가보면 문자객체의 주소.
		int age = 10; // age 주소값에 가보면 10의 값이 담겨있음.
		
		int myAge = age;
		myAge = 20;
//		String myMsg = msg;
//		msg = new String ("Welcome, World");
		
		System.out.println("age=>"+ age + ",MyAge" + myAge );
		System.out.println(msg == "Hello, World"); 
		System.out.println(msg.equals("Hello, World")); 
		                       //equals 이퀄즈 문자값 비교할때 사용
	}
}
