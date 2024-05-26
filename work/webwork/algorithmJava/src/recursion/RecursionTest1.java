package recursion;
//적어도 하나는 재귀에 빠지지 않는 경우 수가 존재해야 한다.
//빠져나오기 위한 조건이 있어야 한다. - base cases
public class RecursionTest1 {
	public  void test(int count) {
		if(count<=0) {
			return; //void메소드에서 return;하면 메소드 실행을 종료하고 호출한 곳으로 되돌아간다.
		}
		System.out.println("재귀알고리즘.....");
		test(count-1);
	}
	public static void main(String[] args) {
		RecursionTest1 obj = new RecursionTest1();
		obj.test(5);
		System.out.println("end");
	}

}
