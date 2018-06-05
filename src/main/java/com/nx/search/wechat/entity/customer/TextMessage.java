package com.nx.search.wechat.entity.customer;

import lombok.Data;

/**
 * 文本消息
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class TextMessage extends CustomerBaseMessage{
	
	/**
	 * 文本消息对象
	 */
	private Text text;

	public TextMessage(Text text) {
		super();
		this.text = text;
	}

	public TextMessage() {
		super();
	}
	
}
