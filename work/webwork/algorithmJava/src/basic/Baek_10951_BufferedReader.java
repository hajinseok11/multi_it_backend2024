package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 * 
 * 1. 테스트케이스 객수가 정해지지 않은 경우 EOF를 체크
 * 2. Scanner 이용
 */
public class Baek_10951_BufferedReader {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while(true) {
			String line = br.readline();
			if(line==null) {
				break;
			}
			String [] resultArr = line.split(" ");
			System.out.println(Integer.parseInt(resultArr[0])+
				Integer.parseInt(resultArr[1]));
		}
	}
}
