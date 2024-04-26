package di.constructor.exam03;

public class MysqlArticleDAO implements IArticleDAO {
	@Override
	public void insert(ArticleDTO article) {
		System.out.println("Mysql에 삽입하기");
	}

}
