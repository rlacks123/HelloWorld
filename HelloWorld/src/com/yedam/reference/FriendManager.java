package com.yedam.reference;

import java.util.Scanner;

/*
 *  친구정보 저장 기능.
 *  1.추가 2.목록 3.조회(숙제) 9.종료
 */

public class FriendManager {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		Friend[] storage = new Friend[10]; // 친구정보 저장할수 있는 공간 10개 확보.
		String searchName = "";
//		storage[0] = new Friend();  // 요렇게 꼭 사용하세요!!!!! 중요...
//		storage[0].friendName = "홍길동";
//		storage[0].friendPhone = "010-1111-1111";
//		storage[0].friendBirth = "1999-01-01";
//		System.out.println(storage[0].friendName);
		
		while(run) {
			System.out.println("1.추가 2.목록 3.조회(숙제) 4.수정(연락처) 5.삭제 9.종료");
			System.out.print("선택>> ");
			
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1: // 추가.
				System.out.print("친구 이름 입력>> ");
				String name = scn.nextLine();
				System.out.print("친구 연락처 입력>> ");
				String phone = scn.nextLine();
				System.out.print("친구 생일 입력>> ");
				String birth = scn.nextLine();
				
				for(int i = 0; i < storage.length; i++) {
//					System.out.println(storage[i]);
					if (storage[i] == null) { // 비어있는 위치에 저장.
						storage[i] = new Friend();
						storage[i].friendName = name;
						storage[i].friendPhone = phone;
						storage[i].friendBirth = birth;
						break; //for 종료.
					    						
					}
				}
				break; //switch 종료.
			case 2: // 목록.
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null) {
						System.out.printf("%4s %14s \n", storage[i].friendName, storage[i].friendPhone, storage[i].friendBirth);
					}
				}
				break;
				
			case 3: // 조회.
				boolean isExists = false;
				System.out.println("조회할 이름 입력>> ");
				searchName = scn.nextLine();
				int idx = -1;
				for (int i = 0; i < storage.length; i++ ) {
					isExists = storage[i].friendName.equals(searchName);
					if(isExists) {
						idx = i;
						break; // for 반복문 종료.
					}
				}
				if (isExists ) {
					System.out.println(storage[idx].friendName+ ", "
							+storage[idx].friendPhone+", "
							+storage[idx].friendBirth);
				} else {
					System.out.println("조회할 이름이 없음");
				} break; // switch 종료.
				
			case 4: // 수정 => 이름, 연락처 입력.
//				boolean isExistss = false;
//				int idxx =-1;
				System.out.println("조회할 이름 입력>> ");
				name = scn.nextLine();
				System.out.println("수정할 연락처 입력>> ");
				phone = scn.nextLine();
				// 10개 중에서 6개 저장, 4개 null, 
				for(int i=0; i< storage.length; i++) {
					if(storage[i] != null) { // null 값이 아닌요소 대상
						if(storage[i].friendName.equals(name)) {
						   storage[i].friendPhone = phone;
						   System.out.println("수정됐습니다");
							break;
//						}if(isExistss) {
//							System.out.println(storage[idxx].friendName+ ", "
//									+storage[idxx].friendPhone+" !! ");
						} else {
							System.out.println("없습니다");
							break;
						}
					}
				}
				break; // switch 종료.
				
			case 5: // 삭제.
//				System.out.print("친구 이름 입력>> ");
//				String name = scn.nextLine();
//				System.out.print("친구 연락처 입력>> ");
//				String phone = scn.nextLine();
//				System.out.print("친구 생일 입력>> ");
//				String birth = scn.nextLine();
//				
//				for(int i = 0; i < storage.length; i++) {
////					System.out.println(storage[i]);
//					if (storage[i] == null) { // 비어있는 위치에 저장.
//						storage[i] = new Friend();
//						storage[i] = null;
//						storage[i] = null;
//						storage[i] = null;
//						break; //for 종료.
//				run = false;
				System.out.println("삭제할 이름 입력>> ");
				name = scn.nextLine();
//				System.out.println("삭제할 연락처 입력>> ");
//				phone = scn.nextLine();
//				System.out.println("삭제할 생일 입력>> ");
//				birth = scn.nextLine();
				
				for(int i=0; i< storage.length; i++) {
					if(storage[i] != null) { // null 값이 아닌요소 대상
						if(storage[i].friendName.equals(name)) {
						   storage[i] = null;
						   System.out.println("삭제됐습니다");
							break;
						} else {
							System.out.println("없습니다");
							break;
						}
					}
				}
				break; // switch 종료.
				
				
				
				
			case 9: // 종료.
				run = false;
				break; //switch 종료.
			default:
				System.out.println("메뉴를 다시 선택하세요");
			
			} // end of switch.
			
		} // end of while.
		System.out.println("프로그램 종료");
	} // end of main().
} // end of class.
