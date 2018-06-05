package com.nx.search.wechat.entity.message.resp;


import lombok.Data;

/**
 * 文本消息
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class TextMessage extends BaseMessage {
	/**
	 * 回复的消息内容
	 */
	private String Content;

	public TextMessage(String content) {
		super();
		Content = content;
	}

	public TextMessage() {
		super();
	}
}