package app3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/*
 * 스프링 IoC컨테이너를 이용해서 작업
 * 	- 스프링은 빈(스프링 컨테이너가 관리하는 객체)에 대한 설명정보를 xml, 어노테이션, 클래스에 정의
 * 	- BeanFactory 컨테이너의 하위 클래스를 이용해서 작업
 */
public class MyBeanTest_Spring_BeanFactory {
	public static void main(String[] args) {
		// 1. xml을 파싱(xml로 만들어진 설정파일을 분석해서 <bean>으로 등록된 엘리먼트의 설정을 보고 객체를 생성
		// => xml을 파싱해주는 기능은 스프링 내부에서 제공되는 객체를 이용
		Resource res = new ClassPathResource("/config/bean.xml"); // src부터 찾는다.
		System.out.println("++++++++++++++++ Resource객체 생성 후 ++++++++++++++++");
		
		// 2. 스프링이 제공하는 IoC컨테이너 (객체를 생성하고 관리하는 기능을 갖고있는 클래스 - ConnectionFactory 같은 역할을 담당하는 클래스)
		// 클래스를 생성
		// => 객체를 요청하면 Resource객체 내부에서 파싱된 정보를 이용해서 객체를 생성해서 필요한 곳으로 넘겨준
		BeanFactory factory = new XmlBeanFactory(res);
		System.out.println("++++++++++++++++ Ioc 컨테이너 객체 생성 후 ++++++++++++++++");
		
		// 3. 원하는 객체를 찾아오기(lookup)
		MyBeanStyle obj = (MyBeanStyle) factory.getBean("mybean");
		MyBeanStyle obj2 = (MyBeanStyle) factory.getBean("mybean");
		if(obj==obj2) {
			System.out.println("같은객체");
		}else {
			System.out.println("다른객체");
		}
		System.out.println("++++++++++++++++ getBean 호출 될 때 ++++++++++++++++");
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
