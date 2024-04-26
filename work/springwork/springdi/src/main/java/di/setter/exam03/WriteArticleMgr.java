package di.setter.exam03;

public class WriteArticleMgr implements IWriteArticleMgr {
	private IArticleDAO articleDAO;
	
	public WriteArticleMgr(IArticleDAO articleDAO) {
		super();
		this.articleDAO = articleDAO;
	}
	public void WriteArticleMgr(IArticleDAO articleDAO) {
		
	}
	@Override
	public void write(ArticleDTO article) {
		articleDAO.insert(article);
	}
}
