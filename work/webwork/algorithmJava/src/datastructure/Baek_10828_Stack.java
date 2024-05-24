package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//데이터를 저장할 수 있는 int형배열이 멤버변수로 정의
//push,pop,top,empty,size메소드를 정의
//MyStack클래스 내부에서 데이터를 저장하기 위한 공간 (스택처럼 활용)
class MyStack{
	private int[] mystack;
	private int top_position;//스택의 top의 위치값 ,top_position변수의 값이 0이라는 것은 스택이 비어있다는 의미
	MyStack(int size){
		mystack = new int[size];
	}
	public void push(int data) {
		mystack[top_position] = data;
		top_position++;
//		System.out.println("배열의 갯수:"+mystack.length);
//		System.out.println("top_position:"+top_position);
	}
	public int size() {
		return this.top_position;
	}
	public int top() {
		if(top_position==0) {
			return -1;
		}else {
			return mystack[top_position-1];
		}
	}
	public int pop() {
		int result = 0;
		if(empty()==1) {//스택이 비어있으면
			result = -1;
		}else {
			top_position = top_position -1;
			result = mystack[top_position];
		}
		return result;
	}
	public int empty() {
		int result = 0;
		if(top_position==0) {
			result = 1;
		}else {
			result = 0;
		}
		return result;
	}
}
public class Baek_10828_Stack {
	public static void main(String[] args) throws IOException {
		//MyStack의 메소드를 호출해서 테스트케이스 데이터를 입력받아 처리했을때 출력형식처럼 출력되도록 작업하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		MyStack stack = new MyStack(count);
		
		for(int i=0;i<count;i++) {
			String line = br.readLine();//한 줄 전체 line을 입력받아 String 리턴
			String[] arr = line.split(" ");//2개 입력 line[0],line[1],1개 입력시 line[0]
			switch(arr[0]) {
				case "push":
					int data = Integer.parseInt(arr[1]);
					stack.push(data);
					break;
				case "pop":	
					System.out.println(stack.pop());
					break;
				case "empty":	
					System.out.println(stack.empty());
					break;
				case "size":	
					System.out.println(stack.size());
					break;
				case "top":	
					System.out.println(stack.top());
					break;
			}
		}
	}
}











