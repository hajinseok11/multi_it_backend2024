package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_10799 {

	public static void main(String[] args) throws IOException {
		// (를 만나면 stack에 넣기
		// )를 만나면 stack의 바로 뒤에 데이터가 (인지 판단해서 (이면 레이저 그렇지 않으면 막대기)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		System.out.println(count(line));
	}
	public static int count(String str) {
		int result = 0; // 잘리는 쇠 막대기의 갯수를 저장할 변수
		Stack<Character> stack = new Stack<>();
		int size = str.length();
		for(int i=0;i<size;i++) {
//			System.out.println(str.charAt(i));
			if(str.charAt(i)=='(') {
				stack.push('(');
			}else {// 닫는 괄호
				stack.pop();
				if(str.charAt(i-1)=='(') { // 레이저 - 바로 직전 문자열
					// 스택에 저장된 (괄호가 막대기의 시작점
					result = result + stack.size();
				}else {
					//쇠막대기 끝
					result = result +1;
				}
				
			}
		}return result;
	}

}
