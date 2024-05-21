package datastructure;

import java.util.Arrays;
import java.util.Random;

/*
 * 랜덤값 1000개를 발생시켜 배열에 저장
 * 1. 1부터 1000까지 랜덤값을 배열에 1000개 저장하기 (1~1000)
 * 2. 최대값을 구하기
 * 3. 최대값의 갯수를 출력하기
 */
public class ArrayExam {
	public static void main(String[] args) {
		Random random = new Random();
		int [] randomNums = new int[1000];
		
		for (int i = 0; i< randomNums.length; i++) {
			randomNums[i] = random.nextInt(1000)+1;
		}
		System.out.println(Arrays.toString(randomNums));
		
		int max = randomNums[0];
		for (int num:randomNums) {
			if (num>max) {
				max = num;
			}
		}
		System.out.println("max=>"+max);

		int count = 0;
		for (int num:randomNums) {
			if (num==max) {
				count++;
			}
		}
		System.out.println("최대값의 갯수=>"+count);
		
	}

}
