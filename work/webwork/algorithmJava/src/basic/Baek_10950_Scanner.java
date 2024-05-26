package basic;

import java.util.Scanner;

/*
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
   각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
   각 테스트 케이스마다 A+B를 출력한다.
    5
	1 1
	2 3
	3 4
	9 8
	5 2    
	[출력값]
	2
	5
	7
	17
	7
	
	17904kb, 228ms
	1. 테스트케이스 갯수가 정해진 경우
	2. Scanner를 이용
 */
public class Baek_10950_Scanner {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int count = key.nextInt();//테스트케이스 갯수
		for(int i=1;i<=count;i++) {
			System.out.println(key.nextInt()+key.nextInt());
		}
	}
}
