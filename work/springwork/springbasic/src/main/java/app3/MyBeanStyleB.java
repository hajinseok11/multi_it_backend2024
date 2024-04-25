package app3;

public class MyBeanStyleB implements MyBeanStyle{
	private String name;
	@Override
	public void testHello(String name) {
		System.out.println("안녕하세요..."+name+"님!!!");
	}
}
