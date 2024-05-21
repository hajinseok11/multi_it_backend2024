package datastructure;

import java.util.Arrays;

// 배열과 관련된 메소드
// Arrays클래스는 배열을 다루는데 필요한 기능을 지원하는 클래스
public class ArrayTest1 {
	public static void main(String[] args) {
		// 배열의 비교
		int [] myarr = {100,20,40,88,99,78};
		// int [] myarr2 = myarr; // 얕은 복사
		int [] myarr2 = myarr.clone(); // 깊은 복사 - 독립적인 배열을 생성
		myarr2[2]=70;
		System.out.println("myarr=>" + Arrays.toString(myarr));
		System.out.println("myarr2=>" + Arrays.toString(myarr2));
		// 배열의 주소비교
		System.out.println(myarr==myarr2);
		// 배열의 값을 비교
		System.out.println(Arrays.equals(myarr, myarr2));
		
		Arrays.sort(myarr); // 원본이 변경
		System.out.println("myarr=>" + Arrays.toString(myarr));
		
		// 배열의 값을 복사
		// 특정 배열에서 index사이의 배열요소를 복사해서 다른 배열로 리턴
		// myarr에서 1번 index에서 4번 index사이의 배열요소를 새로운 배열로 리턴
		int [] otherArr = Arrays.copyOfRange(myarr, 1, 4);
		System.out.println("otherArr=>" + Arrays.toString(otherArr));
		/* binarySearch
		 * 매개변수로 전달받은 배열에서 특정 값의 위치값을 반환
		 * => 내부적으로 이진검색 알고리즘을 사용해서 검색
		 * => 이진검색 알고리즘을 내부에서 사용하므로 사용전에 정렬이 되어 있어야 제대로 동작
		 */
		System.out.println(Arrays.binarySearch(myarr, 78));
	}
}
