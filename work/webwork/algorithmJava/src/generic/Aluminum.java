package generic;
// 재료1
public class Aluminum extends Material{
	public String toString() {
		return "재료는 알루미늄이다.";
	}
	
	@Override
	public void print() {
		System.out.println("알루미늄을 이용해서 프린트합니다.");
	}
}
