package di.annotation.exam03;

import org.springframework.stereotype.Component;

@Component("ArticleDTO")
public class ArticleDTO {
	private String name;
	private String title;
	private String content;
	private String date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ArticleDTO(String name, String title, String content, String date) {
		super();
		this.name = name;
		this.title = title;
		this.content = content;
		this.date = date;
	}
	public ArticleDTO() {}
	
}
