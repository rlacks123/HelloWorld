package com.yedam.reference;

public class TodoExe1 {
	public static void main(String[] args) {
		// 정수를 담는 배열 크기 5개로 선언.
		int[] intAry = new int[5];
		// Math.random() 활용 => 50 ~ 100점 사이의 점수를 저장.
		for (int i=0; i < intAry.length; i++) {
//			intAry[i] = (int) (Math.random ()* 50)+51;
			int temp = (int) (Math.random ()* 5)+50; // 템프 변수에 담음
			// 2번째 -> 1번째, 3번째 -> 2번째까지, 4번쨰 -> 3번까지 비교.
			boolean exists = false;
			for (int j = 0; j <= i - 1; j++) {
				if(intAry[j] == temp) {
					exists = true; // 같은 값이 존재 츄르
				}
			}
			// 같은 값이 존재하면.. i값을 증가X
			if(exists) {
				continue; //컨티뉴 똑같은 값이 있으면 증가X 없으면 밑으로
			}
			intAry[i] = temp;
			i++;
		}
		// 출력
		for (int num : intAry) {
			System.out.println(num);
		}
		System.out.println("end of prog");
	}
}
