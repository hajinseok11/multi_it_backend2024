package search;

import java.util.Scanner;
// 두번째 과제 - 선형검색
// 보초법
// 효율성을 높이기 위해서 사용되는 방법
// 순차검색에서 각요소에 조건을 적용해서 비교하면서 조건을 만족하지 않는 경우에 처리를 진행하므로 이 부분에 대한 연산을 최소화하자
// 보초법은 배열에 마지막에 찾으려고 하는 값을 추가해서 검색 - 추가 조건 검색이 필요
public class SequenceSearch_SentinelTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("찾을 숫자: ");
		int searchValue = key.nextInt();
		int [] arr = {77,19,22,23,7,4,5};
		System.out.println("====size"+arr.length);
		// 찾는 숫자는 배열에서 6번 위치에 있습니다.
		// 찾는 숫자는 배열에 없습니다.
		long start = System.nanoTime();
		int result = search(arr,searchValue);
		long end = System.nanoTime();
		if(result ==1) {
			System.out.println("찾는 데이터가 없늡니다:");
		}else {
			System.out.println("데이터의위치:"+result);
		}
	}
	// searchValue의 위치를 리턴, 없으면 -1을 리턴하기
	// arr가 찾으려고 하는 값이 저장된 배열
	// searchValue가 실제 찾는 값
	public static int search(int[] arr, int searchValue) {
		int result = 0;
		for(int i=0; i<arr.length;i++) {
			if(arr[i]==searchValue) {
				result =i;
				break;
			}
		}
		return result;
	}

}
