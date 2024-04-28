package di.setter.exam03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ArticleDTO dto = new ArticleDTO();
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/setter.xml");
		ArticleDTO article = new ArticleDTO("이름", "제목", "내용", "2024-04-26");
		IWriteArticleMgr articleMgr = (IWriteArticleMgr) factory.getBean("articleMgr");
		articleMgr.write(article);
	}

}
