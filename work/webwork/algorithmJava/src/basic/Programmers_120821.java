package basic;

import java.util.Arrays;

/*
 * 정수가 들어 있는 배열 num_list가 매개변수로 주어집니다. 
 * num_list의 원소의 순서를 거꾸로 뒤집은 배열을 return하도록 solution 함수를 완성해주세요.
 */
class Solution2 {
    public  int[]  solution(int[] num_list ) {
    	int[] answer = new int[num_list.length];
      
        //num_list 거꾸로 뒤집은 배열을 만들어서 리턴
    	/*
    	 * 수도코드
    	 * 1. 배열을 탐색할 수 있도록 반복문을 실행
    	 * 2. 매개변수 num_list 0에서 하나씩 꺼내기
    	 * 3. answer 마지막 index에 데이터 넣어주기
    	 */
    	int j = num_list.length-1;
    	for(int i=0;i<num_list.length;i++) {
    		answer[j]=num_list[i];
    		j--;
    	}
    	return answer;
    }
}
//배열뒤집기
public class Programmers_120821 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] test1 = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(sol.solution(test1)));
		
	}

}
