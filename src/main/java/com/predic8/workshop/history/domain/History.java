package com.predic8.workshop.history.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class History {
	@Id
	private String id;
	@JsonIgnore
	private String customerId;
	private List<String> articleIds;

	public History() {
	}

	public History(String customerId, List<String> articleIds) {
		this.customerId = customerId;
		this.articleIds = articleIds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getArticleIds() {
		return articleIds;
	}

	public void setArticleIds(List<String> articleIds) {
		this.articleIds = articleIds;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
