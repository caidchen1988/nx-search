package com.nx.search.wechat.entity.customer;

import lombok.Data;

import java.util.List;

/**
 * 多图文消息对象
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class News {
	
	/**
	 * 多条图文消息信息列表，默认第一个item为大图
	 */
	private List<Article> Articles;

	public News(List<Article> articles) {
		super();
		Articles = articles;
	}

	public News() {
		super();
	}
	
}
