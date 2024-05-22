package search;

import java.util.Scanner;

public class SequenceSearchTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int [] arr = {77,19,22,23,7,4,5};
		System.out.println("찾을 숫자: ");
		int searchValue = key.nextInt();
	
		search(arr,searchValue);
	}
	public static int search(int[] arr, int searchValue) {
		return 0;
	}

}
