package dept;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class DeptSystem {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		
		ApplicationContext factory = 
			 new ClassPathXmlApplicationContext("/config/dept.xml");
		AbstractUI ui = (AbstractUI)factory.getBean("menu",AbstractUI.class);
		while(true){
			ui.show();
		}
	}
}
