package di.constructor.exam03;

public class OracleArticleDAO implements IArticleDAO {
	@Override
	public void insert(ArticleDTO article) {
		System.out.println("오라클에 insert하기");
	}
	
	
}
