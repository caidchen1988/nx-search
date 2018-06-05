package com.nx.search.wechat.entity.message.resp;

import lombok.Data;

import java.util.List;

/**
 * 多图文消息，
 * 单图文的时候 Articles 只放一个就行了
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class NewsMessage extends BaseMessage {
	/**
	 * 图文消息个数，限制为10条以内
	 */
	private int ArticleCount;
	/**
	 * 多条图文消息信息，默认第一个item为大图
	 */
	private List<Article> Articles;

	public NewsMessage(int articleCount, List<Article> articles) {
		super();
		ArticleCount = articleCount;
		Articles = articles;
	}

	public NewsMessage() {
		super();
	}
}