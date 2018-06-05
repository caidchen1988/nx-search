package com.nx.search.wechat.entity.customer;

import lombok.Data;

/**
 * 文本消息对象
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class Text {
	/**
	 * 回复的消息内容
	 */
	private String content;

	public Text(String content) {
		super();
		this.content = content;
	}

	public Text() {
		super();
	}
	
}
