package search;

import java.util.Arrays;
import java.util.Scanner;

// 이진 탐색의 조건은 정렬이 기본으로 되어있는 상태
public class BinarySearchTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		// 4,5,7,19,22,23,33,77
 		int [] arr = {77,19,22,23,7,4,5,33};
		Arrays.sort(arr); // 원본이 변경
		System.out.println(Arrays.toString(arr));
		int result = search(arr,searchValue);
		if(result ==1) {
			System.out.println("찾는 데이터가 없늡니다:");
		}else {
			System.out.println("데이터의위치:"+result);
		}
	}
	public static int search(int [] arr,int searchValue) {
		int searchIndex = -1;
		// 시작 index, 종료 index, 중앙 index
		// 찾는 위치는 원본에서 보이는 위치가 아니라 정렬된 배열에서의 위치
		// 1. 전체 배열에서 중앙값을 찾는다.
		// 2. 중앙값과 찾는 값을 비교
		// 3. 중앙값>찾는값일 때 중앙값을 기준으로 왼쪽의 데이터들만 비교
		// 4. 중앙값<찾는값일 때 중앙값을 기준으로 오른쪽의 데이터만 비교
		// 5. 1~4번까지를 값을 찾을 때까지 반복(index를 변경)
		int startIndex = 0;
		int endIndex = arr.length-1;
		// 중앙값
		int mediumIndex = 0;
		while(startIndex<=endIndex) {
			mediumIndex = (startIndex+endIndex)/2;
			System.out.println(startIndex+","+mediumIndex+","+endIndex);
			// 중앙값과 찾으려고 하는 값을 비교 -> , <, ==
			if(arr[mediumIndex]>searchValue) {
				searchIndex = mediumIndex;
			}else if (arr[mediumIndex]>searchValue) {
				// 찾으려는 값보다 중앙값이 더 크면 중앙값 뒤의 값들은 처리하지 않는다.
				endIndex = mediumIndex-1;
			}else {
				// 찾으려는 값보다 중앙값이 더 작으면 중앙값 앞의 갚들은 처리하지 않는다.
				startIndex = mediumIndex+1;
			}
		return searchIndex;
		}
	}
}

