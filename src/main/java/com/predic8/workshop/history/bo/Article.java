package com.predic8.workshop.history.bo;

public class Article {
	private String article;
	private long quantity;

	public Article() {
	}

	public Article(String article, long quantity) {
		this.article = article;
		this.quantity = quantity;
	}

	public String getArticle() {
		return this.article;
	}

	public long getQuantity() {
		return this.quantity;
	}

	public String toString() {
		return "Article(article=" + article + ", quantity=" + quantity;
	}
}