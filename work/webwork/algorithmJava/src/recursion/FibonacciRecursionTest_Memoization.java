package recursion;

import java.util.Scanner;
//배열에 저장하고 리턴
//한 번 작업했던 내용은 기록해 놓고 재사용하기 - 이미 저장된 것은 다시 메소드를 호출하지 않고 배열에 저장된 것을 꺼내서 리턴하는 코드로 수정하기
//코드추가
public class FibonacciRecursionTest_Memoization{
	static int[] myarr;
	public static int getFibonacci(int count) {
		//이미 저장된 것은 다시 메소드를 호출하지 않고 배열에 저장된 것을 꺼내서 리턴하는 코드로 수정하기
		if(myarr[count]>0) {
			return myarr[count];
		}
		if(count==1 | count==2) {
			return  myarr[count] = 1;
		}else {
			return  myarr[count] = getFibonacci(count-2)+getFibonacci(count-1);
		}
		//return result;
	}
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int num = key.nextInt();
		myarr = new int[num+1];
		getFibonacci(num);
		for(int i=1;i<=num;i++) {
			System.out.print(myarr[i]+"\t");
			if(i%5==0) {
				System.out.println();
			}
		}
	}

}
