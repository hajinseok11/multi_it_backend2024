package search;

import java.util.Scanner;
//두번째 과제 - 선형검색
public class SequenceSearchTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int[] arr = {77,19,22,23,7,4,5};
		System.out.print("찾을 숫자:");
		int searchValue = key.nextInt();
		long start = System.nanoTime();
		int result = search(arr, searchValue);
		long end = System.nanoTime();
		System.out.println("걸린시간:"+(end-start));
		//찾는 숫자는 배열에서 6번 위치에 있습니다. 
		//찾는 숫자는 배열에 없습니다.
		if(result==-1) {
			System.out.println("찾는데이터가 없습니다.");
		}else {
			System.out.println("데이터의 위치:"+result);
		}
		
	}
	//searchValue의 위치를 리턴 , 없으면 -1을 리턴하기
	//arr가 찾으려고 하는 값이 저장된 배열
	//searchValue가 실제 찾는 값
	public static int search(int[] arr,int searchValue) {
		int result = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==searchValue) {
				result = i;
				break;
			}else {
				result = -1;
			}
			
		}
		return result;
	}
}
