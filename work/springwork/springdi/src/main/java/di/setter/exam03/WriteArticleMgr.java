package di.setter.exam03;

public class WriteArticleMgr implements IWriteArticleMgr {
	private IArticleDAO articleDAO;
	
	public WriteArticleMgr() {

	}
	public WriteArticleMgr(IArticleDAO articleDAO) {
		super();
		this.articleDAO = articleDAO;
	}
	@Override
	public void write(ArticleDTO article) {
		articleDAO.insert(article);
	}
	public IArticleDAO getArticleDAO() {
		return articleDAO;
	}
	public void setArticleDAO(IArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	
}