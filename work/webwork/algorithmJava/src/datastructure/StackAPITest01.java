package datastructure;

import java.util.Stack;

public class StackAPITest01 {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		// 스택에 데이터를 저장하기
		stack.push("java");
		stack.push("servlet");
		stack.push("jsp");
		
		System.out.println("스택에 저장된 요소의 갯수=> "+stack.size());
		System.out.println("스택에 저장된 요소가 있나?=> "+stack.empty()); // 스택에 저장된 요소가 없을 때 true리턴
		System.out.println("스택에 마지막으로 저장된 요소를 확인 => "+stack.peek());
		System.out.println("스택에 저장된 요소의 갯수 => "+stack.size());
		
		System.out.println("스택에서 데이터 꺼내기=> "+stack.pop());
		System.out.println("스택에서 데이터 꺼내기=> "+stack.pop());
		System.out.println("스택에서 데이터 꺼내기=> "+stack.pop());
		System.out.println("스택에서 데이터 꺼내기=> "+stack.pop());
		System.out.println("스택에 저장된 요소의 갯수 => "+stack.size());
		System.out.println("스택에 저장된 요소의 갯수 => "+stack.empty());
		
		System.out.println();
	}
}
