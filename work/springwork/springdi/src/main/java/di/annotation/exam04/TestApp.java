package di.annotation.exam04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import di.annotation.exam02.MyService;
import di.annotation.exam02.ServiceImpl;

public class TestApp {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/anno.xml");
		
		MessageBean bean = factory.getBean("messageBean",MessageBean.class);
		System.out.println(bean.getName());
		
		FileOutputter fileoutputter = factory.getBean("fileoutputter",FileOutputter.class);
		System.out.println(fileoutputter.getFilePath());
	}

}
