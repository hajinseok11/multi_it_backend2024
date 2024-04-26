package di.annotation.exam03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("mgr")
public class WriteArticleMgr implements IWriteArticleMgr {
	@Autowired
	@Qualifier("mysql")
	private IArticleDAO articleDAO;
	
	public WriteArticleMgr(IArticleDAO articleDAO) {
		super();
		this.articleDAO = articleDAO;
	}
	public void WriteArticleMgr(IArticleDAO articleDAO) {
		
	}
	public void WriteArticleMgr() {
		
	}
	@Override
	public void write(ArticleDTO article) {
		articleDAO.insert(article);
	}
}
