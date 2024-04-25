package di.constructor.exam02;

public class ServiceImpl implements MyService {
	String name;
	String msg;
	Logic logic;
	// Main만들때 ServiceImpl의 testService 메소드를 호출
	@Override
	public void testService() {
		System.out.println(msg+","+name);
		logic.testLogic();
	}
	public ServiceImpl(String name, String msg, Logic logic) {
		super();
		this.name = name;
		this.msg = msg;
		this.logic = logic;
	}
	

	
}
