package app3;

public class MyBeanStyleA implements MyBeanStyle {
	public MyBeanStyleA() {
		System.out.println("기본생성자 - MyBeanStyleA");
	}
	@Override
	public void testHello(String name) {
		System.out.println("hello...."+name + " 님!!!");
	}
	
}
