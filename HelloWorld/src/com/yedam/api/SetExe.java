package com.yedam.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 *  hashCode() 메소드의 오버라이딩.
 */
public class SetExe {
	public static void main(String[] args) {
		
		// Map 컬렉션. 키 & 값을 저장.
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "홍길동");
		map.put(200, "김길동");
		map.put(300, "최길동");
		
		String result =  map.get(100); // 키 => 값 을 반환.
		System.out.println(result);
		
		Set<Integer> Kset = map.keySet(); //키값들을 set에 반환. (맵 컬렉션에서 키값만 뽑아서  셋 컬랙션에 담아줌)
		for(Integer key : Kset) {
			System.out.printf("key: %d, value %s\n", key, map.get(key));
		}
		
		System.out.println("end of prog");
		
 }
	
	
public void set() {
//Set => 중복값 값은 저장X.
		HashSet<Student> students = new HashSet<Student>();
		students.add(new Student(1001, "홍길동", 80));
		students.add(new Student(1002, "김민동", 70));
		students.add(new Student(1003, "최우동", 60));
		students.add(new Student(1004, "박길돈", 50));
		students.add(new Student(1001, "홍길동", 80));
		
		for (Student std : students) {
			System.out.println(std);
		}
		
		HashSet<String> set = new HashSet<String>();
		set.add("Hello");
		set.add("World");
		set.add("Hello"); // 중복값 저장안됨
		
		// 중복값 저장X HashSet
		for (String str : set) {
			System.out.println(str);
		}
}


// 코드백업
public void list() {

	// Collection -> List(인덱스 활용해서 저장), Set(집합), Map(키, 값)
	
	ArrayList<String> list = new ArrayList<String>(); //<String> 이해하기
	list.add("apple"); // [0] 첫번째위치
	list.add("orange"); // [1]
	String vl = list.get(0); // Object -> String
	
	// 컴파일 세점에 에러 발생.
	// 실행에로 보다는 컴파일러에 유리.
	for (int i=0; i < list.size(); i++) {
		String result = (String) list.get(1);
	}
}
}

//코드 백업
//---------
//// Student 객체.
//ArrayList<Student> students = new ArrayList<Student>();
//
//students.add(new Student(1001, "홍길동", 80));
//students.add(new Student(1002, "김민동", 70));
//students.add(new Student(1003, "최우동", 60));
//students.add(new Student(1004, "박길돈", 50));
//students.add(new Student(1001, "홍길동", 80));
//
//for(Student std : students) {
//	if (std.getScore() > 50) // 점수 50이상만 출력
//	System.out.println(std);
//}
//
//ArrayList<String> strList = new ArrayList<String>();
//strList.add("Hello");
//strList.add("World");
//strList.add(0, "Nice"); // 첫번째에 0을 넣어서 제일먼저 시작
//
//strList.remove(1); // 리무브 2번째 값 헬로우 지우기
//
//System.out.println("strList의 크기 " + strList.size());
//
//// 조회.
//for(int i=0; i<strList.size(); i++) {
//	System.out.println(strList.get(i)); // strList[0]		
//	
//}