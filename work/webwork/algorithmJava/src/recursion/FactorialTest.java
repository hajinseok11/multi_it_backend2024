package recursion;

public class FactorialTest {
	public int factorial(int num) {
		int result = 0;
		if(num==0) {
			result =1;
		}else {
			result = num * factorial(num-1);
		}
		return result;
	}
	public static void main(String[] args) {
		FactorialTest obj = new FactorialTest();
		System.out.println(obj.factorial(5));
		System.out.println("==================================");
		int sum=1;
		for(int i=1;i<=5;i++) {
			sum = sum * i;
		}
		System.out.println(sum);
	}

}
