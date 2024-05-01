package springtest;

import org.springframework.*;

public class Test {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("/config/bean.xml");
	}

}
