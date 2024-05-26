package sort;

import java.util.Arrays;

//선택정렬 알고리즘을 적용해서 구현하기
public class SelectionSortTest {
	public static void main(String[] args) {
		int[] arr = {77,19,22,23,7,4,5};
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<arr.length;i++) {
			//순서대로 앞에서 부터 작은 값을 위치할 것이므로 i
			//작은 값을 만나는 경우 index를 저장
			int minIndex = i;//최초작업은 minIndex=0
			for(int j=i+1;j<arr.length;j++) {
				if(arr[minIndex]>arr[j]) {//현재 작은 값보다 더 작은 값을 만나는 경우 index를 변경
					minIndex = j;
				}
			}//첫 번째 순회가 완료되면 minIndex가 제일 작은 요소가 저장된 index
			//swap
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			System.out.println(Arrays.toString(arr));
		}
		System.out.println("===================================");
		System.out.println(Arrays.toString(arr));
	}

}
