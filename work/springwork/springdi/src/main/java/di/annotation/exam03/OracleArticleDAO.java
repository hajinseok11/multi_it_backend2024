package di.annotation.exam03;

import org.springframework.stereotype.Repository;

@Repository("oracle")
public class OracleArticleDAO implements IArticleDAO {
	@Override
	public void insert(ArticleDTO article) {
		System.out.println("오라클에 insert하기");
	}
	
	
}
