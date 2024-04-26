package di.annotation.exam03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/anno.xml");
		IWriteArticleMgr mgr = factory.getBean("mgr",IWriteArticleMgr.class);
		ArticleDTO dto = new ArticleDTO();
		
		dto.setName("백엔드");
		dto.setTitle("스프링");
		dto.setContent("의존성 주입");
		dto.setDate("2024-04-26");
		mgr.write(dto);
	}

}
