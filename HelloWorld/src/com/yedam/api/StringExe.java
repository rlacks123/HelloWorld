package com.yedam.api;
/*
 *  String 메소드 연습
 */
public class StringExe {
	public static void main(String[] args) {
//		String str = "안녕하세요";
//		byte byres1 = str.getBytes();
//		Sytem.out.println(bytes1.length: " + bytes1.length");
//		String str = new String(byres1);
//		System.out.println(bytes1 -> StrString: strl);
//	
	
	
		
	}
//		public void id() {
//		String strVar1 = new String("신민철");
//		String strVar2 = "신민철";
//		
//		if(strVar1 == strVar2) {
//			System.out.println("같은 String 객체를 참조");
//		} else {
//			System.out.println("다른 String 객체를 참조");
//		}
//		
//		if(strVar1.equals(strVar2)) {
//			System.out.println("같은 문자열을 가짐");
//		}else {
//			System.out.println("다른 문자열을 가짐");
//		} System.out.println("end of prog");
//	-----
	public void id() { //주민번호 남여 구별
	String str ="AHello, World"; // 유니코드 숫자로 변환 연습
	// 19960503 1234567
	str = "19960503 1234567";
	char c1 = str.charAt(9);
	switch(c1) {
	case '1':System.out.println("남");break;
	case '2':System.out.println("여");break;
	default: System.out.println("알수없음");break;
	}
	System.out.println(c1 + ", " + (int) c1);
	}
}
