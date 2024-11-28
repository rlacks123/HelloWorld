package com.yedam;

// 대소문자 구분 (A - a 서로 다름)
// 자바는 객체지향언어 (Object Oriented Language)
public class Hello {

	// 메소드 여러개를 선언. start(), main(); 스타트 , 메인

	public static void start() {
		System.out.println("시작합니다");
	}

	// 메인 메소드. 함수(function) 펑션
	public static void main(String[] args) {
		// 콘솔에 Hello, World 출력.
		System.out.println("Hello, World");
		start(); // 메인 메소드에 스타트 호출하여 실행됨

		// let result = "Hello";
		OperationExe exe = new OperationExe();
		exe.sum(10, 20);

		// Hello.java -> Hello.class(실행파일) 이렇게변함 변화하는 과정을 컴파일이라함
		// 컴파일 (저장하면 eclipse 컴파일)
		// HelloWorld 프로젝트 - HelloWorld repository 연결

	}
} // end of class
