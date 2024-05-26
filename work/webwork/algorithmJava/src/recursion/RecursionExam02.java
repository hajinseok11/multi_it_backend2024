package recursion;
//sumArr는 수정가능
//배열의 합을 구할 수 있도록 작업 - 매개변수는 알아서 정의(수정가능)
//배열의 합을 재귀를 이용해서 처리
//input데이터가 점진적으로 변할 수 있도록 정의(대부분은 하나씩 줄어들도록 작업)
// - 재귀호출을 빠져나올 수 있는 조건
public class RecursionExam02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {55,88,77,99,100};
		System.out.println(sumArr(arr,arr.length));
	}
	public static int sumArr(int[] arr,int size) {
		if(size<=0) {
			return 0;
		}else {
			//System.out.println(arr[size-1]);
			return sumArr(arr, size-1)+arr[size-1];
		}
	}
}
