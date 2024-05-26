package sort;

import java.util.Arrays;

//삽입정렬을 이용해서 정렬하세요(오름차순)
public class InsertionSortTest {
	public static void main(String[] args) {
		int[] arr = {42,32,24,60,40};
		System.out.println(Arrays.toString(arr));
		//0번요소는 정렬된 값이라 판단하고 작업
		//정렬되지 않은 영역에서 첫 번째 데이터
		for(int i=1;i<arr.length;i++) {
			//정렬된 영역의 마지막 데이터부터 역순(뒤에서 부터 앞으로 가면서 비교)으로 비교
			for(int j=i;j>0;j--) {
				System.out.println("i="+i+",j="+j+",arr[j]=>"+arr[j]+",arr[j-1]="+arr[j-1]);
				if(arr[j]<arr[j-1]) {
					//더 작은 값을 앞으로 이동 => 작은 값을 비교 요소의 왼쪽 앞으로 삽입
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}else {
					//앞쪽에 있는 요소에서 작은 값을 만나면 이미 정렬되어 있으므로 더 비교할 필요가 없다.
					break;
				}
				System.out.println(Arrays.toString(arr));	
			}
			System.out.println();
		}
		//최종완료
		System.out.println(Arrays.toString(arr));
	}

}















