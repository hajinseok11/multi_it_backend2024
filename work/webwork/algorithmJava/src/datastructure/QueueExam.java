package datastructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//2번째 풀어볼 예제 -10845번문제
//1번부터 10번까지 큐에 추가하고
//데이터가 추가된 큐를 배열로 변환해서 출력하기
public class QueueExam {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=10;i++) {
			queue.add(i);
		}
		int[] arr = new int[queue.size()];//로직
		Object[] arr2 = queue.toArray();//메소드
		for(int i=0;i< arr.length;i++) {
			arr[i] = queue.poll();
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
	}
}