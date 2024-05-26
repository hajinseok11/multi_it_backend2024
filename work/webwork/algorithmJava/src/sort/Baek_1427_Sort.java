package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//선택정렬로 내림차순정렬하기
public class Baek_1427_Sort {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = br.readLine();
		int[] myarr = new int[data.length()];
		for(int i=0;i<myarr.length;i++) {
			myarr[i] = Integer.parseInt(data.charAt(i)+"");
		}
		for(int i=0;i<myarr.length;i++) {
			int maxIndex = i;////가장 큰 값이 현재 맨 앞의 요소라고 가정하고 작업
			for(int j=i+1;j<myarr.length;j++) {
				if(myarr[maxIndex]<myarr[j]) {//max값보다 큰 값이 있는지 확인
					maxIndex = j;
				}
			}//첫 번째 순회가 완료되면 minIndex가 제일 작은 요소가 저장된 index
			//swap
			int temp = myarr[i];
			myarr[i] = myarr[maxIndex];
			myarr[maxIndex] = temp;
			System.out.println(Arrays.toString(myarr));
		}
	}
}
