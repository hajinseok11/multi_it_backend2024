package basic;

import java.util.Scanner;

/*
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.

	17904kb, 228ms
	1. 테스트케이스 갯수가 정해지지 않은 경우 - EOF를 체크
	2. Scanner를 이용
 */
public class Baek_10951_Scanner {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		while(key.hasNextInt()) {
			System.out.println(key.nextInt()+key.nextInt());
		}
	}
}
