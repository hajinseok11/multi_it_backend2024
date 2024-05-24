package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_2164_Queue {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<>();
		int count = Integer.parseInt(br.readLine());
		//1부터 n까지 큐에 저장
		for(int i=1;i<=count;i++) {
			queue.offer(i);
		}
		//System.out.println(Arrays.toString(queue.toArray()));
		while(queue.size()>1) {//한장 남을때까지 반복작업
			queue.poll();
			int data = queue.poll();
			queue.add(data);
		//	System.out.println(Arrays.toString(queue.toArray()));
		}
		System.out.println(queue.peek());
	}
}
