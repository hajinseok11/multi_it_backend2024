package sort;

import java.util.Arrays;

public class SwapTest {
	public static void main(String[] args) {
		int [] num = {4,5,2,4,8,9};
		System.out.println(Arrays.toString(num));
		// 5와 8을 교환(swap)
		int temp = num[1];
		num[1] = num[4];
		num[4] = temp;
		System.out.println(Arrays.toString(num));
	}

}
