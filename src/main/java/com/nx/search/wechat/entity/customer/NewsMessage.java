package com.nx.search.wechat.entity.customer;

import lombok.Data;

/**
 * 发送图文消息
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class NewsMessage extends CustomerBaseMessage{
	
	/**
	 * 图文消息对象
	 */
	private News news;

	public NewsMessage(News news) {
		super();
		this.news = news;
	}

	public NewsMessage() {
		super();
	}
	
}
