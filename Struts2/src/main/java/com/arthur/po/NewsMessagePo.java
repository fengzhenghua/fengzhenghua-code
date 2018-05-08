package com.arthur.po;

import java.util.List;

import com.arthur.base.BaseMessagePo;
import com.arthur.base.News;

public class NewsMessagePo extends BaseMessagePo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5463602893149165095L;
	
	private int ArticleCount ;
	private List<News> Articles;
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<News> getArticles() {
		return Articles;
	}
	public void setArticles(List<News> articles) {
		Articles = articles;
	} 
	
	
}
