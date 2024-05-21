package datastructure;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("숫자 3개입력");
		System.out.print("숫자1: ");
		int num1 = key.nextInt();
		System.out.print("숫자2: ");
		int num2 = key.nextInt();
		System.out.print("숫자3: ");
		int num3 = key.nextInt();
		
		// num1, num2, num3중 최대값을 구해서 출력하기
		int max = num1;
		if (num2>max) {
			max = num2;
		}
		if (num3>max) {
			max = num3;
		}
		System.out.println("최대값=> " + max);
	}

}
