package di.annotation.exam03;

import org.springframework.stereotype.Repository;

@Repository("mysql")
public class MysqlArticleDAO implements IArticleDAO {
	@Override
	public void insert(ArticleDTO article) {
		System.out.println("Mysql에 삽입하기");
	}

}
