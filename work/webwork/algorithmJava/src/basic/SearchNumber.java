package basic;

import java.util.Scanner;

// 시간복잡도 테스트 - 빅오표기법
// 빅오표기법은 최악의 경우를 체크하는 표기법으로 불필요한 연산을 제거해서 알고리즘 분석을 쉽게 하기 위한 목적으로 사용
// 시간 복잡도 - 실행되는 연산의 횟수(cpu의 처리속도)
// 공간 복잡도 - 실행될 때 사용하는 메모리
public class SearchNumber {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int[] numArr = {20,40,60,70,90};
		System.out.println("숫자입력");
		int searchNum = key.nextInt();
		// searchNum을 찾는 코드를 구현하세요 - searchNum이 몇 번만에 찾아지는지 테스트
		
		// [출력형태]
		// 숫자입력:20
		// 1회에 찾기 성공! O(n)
		for (int i=0; i<=numArr.length; i++) {
			if(numArr[i]==searchNum) {
				System.out.println((i+1)+"회에 찾기 성공~~");
			}
		}
	}
}


