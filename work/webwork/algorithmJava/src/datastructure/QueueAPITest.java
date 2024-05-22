package datastructure;

import java.util.LinkedList;
import java.util.Queue;

/*
 * rear : 큐의 가장 끝쪽 데이터가 삽입되는 위치
 * front : 큐의 가장 앞쪽
 * add : 큐의 rear에 데이터를 삽입
 * poll : front부분에 저장된 데이터를 삭제
 * peek : 큐의 맨 앞 부분 즉 front에 있는 데이터를 확인
 * 
 */
public class QueueAPITest {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		// 큐에 데이터를 저장하기
		System.out.println(queue.add(1)); // 실행완료 true, 작업이 처리되지 않으면 Exception 발생
		System.out.println(queue.offer(2)); // 실행완료 true, 작업이 처리되지 않으면 false
		queue.offer(3);
		queue.offer(4);
		
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty());
		System.out.println("사이즈=>"+queue.size());
		System.out.println(queue.poll()); // front의 요소를 꺼내고 결과를 출력(비어있으면 null)
		System.out.println(queue.remove()); // front의 요소를 꺼내고 결과를 출력(비어있으면 Exception발생)
		System.out.println("사이즈=>"+queue.size());
//		System.out.println(queue.poll());
		System.out.println(queue.remove());
	}
}
