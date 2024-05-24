package datastructure;

import java.util.Arrays;
import java.util.Random;

/*
 * 랜덤값 1000개를 발생시켜 배열에 저장
 * 1. 1부터 1000까지 랜덤값을 배열에 1000개저장하기(1~1000) 
 * 2. 최대값을 구하기 
 * 3. 최대값의 갯수를 출력하기 
 */
public class ArrayExam {
	public static void main(String[] args) {
		int[] myarr = new int[1000];
		Random rand = new Random();
		for(int i=0;i<myarr.length;i++) {
			myarr[i] = rand.nextInt(1000)+1;
		}
		System.out.println(Arrays.toString(myarr));
		int max = myarr[0];
		for(int num:myarr) {
			if(num>max) {
				max = num;
			}
		}
		System.out.println("max=>"+max);
		
		int count = 0;
		for(int num:myarr) {
			if(num==max) {
				count++;
			}
		}
		System.out.println("최대값의 갯수=>"+count);
	}
}
