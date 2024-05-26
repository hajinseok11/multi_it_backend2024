package recursion;

public class RecursionExam01 {
	public static void main(String[] args) {
		//length호출해서 "java"라는 문자열의 길이를 리턴할 수 있도록 처리하세요.
		int result = length("java");
		System.out.println("문자열의 길이=>"+result);
	}
	public static int length(String str) {
		//재귀를 이용해서 문자열의 길이를 구할 수 있도록 작업
		//System.out.println(str.substring(1));
		if(str.equals("")) {
			return 0;
		}else {
			return 1+length(str.substring(1));
		}
	}
}
