package first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HrDAOTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/hr.xml");
		HrDAO dao = factory.getBean("hrDAO",HrDAO.class);
		System.out.println("조회된 레코드 수: "+ dao.count());
	}
	

}
