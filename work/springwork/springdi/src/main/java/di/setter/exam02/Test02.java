package di.setter.exam02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/setter.xml");
		MyService bean = factory.getBean("service", MyService.class);
		bean.testService();
		
	}

}
