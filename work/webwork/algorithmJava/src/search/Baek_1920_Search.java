package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_1920_Search {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//1. 검색할 원본배열을 입력 받아 만들기
		int datasize = Integer.parseInt(br.readLine());
		int[] dataarr = new int[datasize];
		//n개의 숫자만큼 입력을 받아서 배열에 저장
		String dataline = br.readLine();
		//spacebar기준으로 분리
		String[] stringarr = dataline.split(" ");
		for(int i=0;i<datasize;i++) {
			dataarr[i] = Integer.parseInt(stringarr[i]);
		}
		//2. 배열을 정렬하기
		Arrays.sort(dataarr);
		//3. 찾을 문자열과 갯수를 입력 받아서 배열로 변환 후 검색
		int searchSize = Integer.parseInt(br.readLine());
		String searchline = br.readLine();
		String[] searchValueArr = searchline.split(" ");
		//찾을 숫자의 갯수만큼 for문을 반복해서 실행해서 찾을 숫자를 입력받아 해당 배열에 있는지 찾기
		for(String searchValue:searchValueArr) {
			System.out.println(search(dataarr, Integer.parseInt(searchValue)));
		}
	}
	//값이 있는 경우 1을 반환 없는 경우 0을 반환
	public static int search(int[] arr,int searchValue) {
		int searchIndex = 0;
		int startIndex = 0;
		int endIndex = arr.length-1;
		//중앙값
		int mediumIndex = 0;
		while(startIndex<=endIndex) {
			mediumIndex = (startIndex+endIndex)/2;
			//System.out.println(startIndex+","+mediumIndex+","+endIndex);
			//중앙값과 찾으려고 하는 값을 비교 - > , <, ==
			if(arr[mediumIndex]== searchValue) {
				searchIndex = 1;
				break;
			}else if(arr[mediumIndex]>searchValue) {
				//찾으려는 값보다 중앙값이 더 크면 중앙값 뒤의 값들은 처리하지 않는다.
				endIndex = mediumIndex - 1;
			}else {
				//찾으려는 값보다 중앙값이 더 작으면 중앙값 앞의 값들은 처리하지 않는다.
				startIndex = mediumIndex +1;
			}
		}
		return searchIndex;
	}
}
