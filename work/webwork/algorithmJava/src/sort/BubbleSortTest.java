package sort;

import java.util.Arrays;

//버블정렬
//-> 바로 옆에 있는 값을 비교해서 작은 숫자를 앞으로 큰 숫자를 뒤로 교환
//-> 반복
public class BubbleSortTest {
	public static void main(String[] args) {
		int[] arr = {77,19,22,23,7,4,5};
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				System.out.println("i:"+i+",j:"+j+",arr[j]="+arr[j]+",arr[j+1]="+arr[j+1]);
				//비교
				if(arr[j]>arr[j+1]) {
					//swap하기 - 값이 큰 경우 뒤쪽으로 보내기
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			System.out.println(Arrays.toString(arr));
			System.out.println();
		}
	}
}
