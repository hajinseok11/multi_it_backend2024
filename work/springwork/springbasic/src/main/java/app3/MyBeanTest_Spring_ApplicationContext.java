package app3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * 스프링 IoC컨테이너를 이용해서 작업
 * - 스프링은 빈(스프링 컨테이너가 관리하는 객체)에 대한 설명정보를 xml, 어노테이션, 클래스에 정의
 * - ApplicationContext이용해서 객체를 관리
 * - getBean을 이용해서 lookup
 */
public class MyBeanTest_Spring_ApplicationContext {
	public static void main(String[] args) {
		// 1. IoC컨테이너를 생성 - ApplicationContext 
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/bean.xml");
		System.out.println("++++++++++ ApplicationContext 객체생성후 ++++++++++");
		// MyBeanStyle타입의 obj가 스프링 컨테이너가 관리하는 빈
		MyBeanStyle obj = (MyBeanStyle) factory.getBean("mybean");
		System.out.println("++++++++++ getBean 호출 후 ++++++++++");
		
		run(obj);
		show(obj);
		change(obj);
	}
	public static void run(MyBeanStyle obj) {
		System.out.println("========================");
		obj.testHello("BTS");
		System.out.println("========================");
	}
	public static void show(MyBeanStyle obj) {
		obj.testHello("BTS");
		obj.testHello("BTS");
		obj.testHello("BTS");
		obj.testHello("BTS");
		obj.testHello("BTS");
	}
	public static void change(MyBeanStyle obj) {
		System.out.println("*************************");
		obj.testHello("BTS");
		obj.testHello("BTS");
		System.out.println("*************************");
	}

}
