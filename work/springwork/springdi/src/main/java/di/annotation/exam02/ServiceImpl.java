package di.annotation.exam02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("Service")
public class ServiceImpl implements MyService {
	@Value("BTS")
	String name;
	@Value("멋있다~~~")
	String msg;
	@Autowired
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
	public ServiceImpl() {}

	
}
