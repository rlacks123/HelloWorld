package com.yedam.variable;

public class TodoExe5 {
	public static void main(String[] args) {
		// 1에서 100까지의 정수 중 3의 배수의 합을 구하고 출력.

		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				System.out.println(i);
			}
		}
		for (int j = 1; j <= 100; j++) {
			if (j % 3 == 0) {
				sum += j;
			}
		}
		System.out.println("1부터 100까지 정수중 3의 배수합" + sum);

		// *
		// **
		// ***
		// ****
		// *****

		for (int i = 5; i >= 5; i--) {
			for (int j = 1; j <= 5; j++) {
				// ____*
				if (j >= i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println("end of prog");
	}
}
