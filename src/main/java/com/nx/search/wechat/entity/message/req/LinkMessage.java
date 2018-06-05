package com.nx.search.wechat.entity.message.req;

import lombok.Data;

/**
 * 链接消息
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class LinkMessage extends BaseMessage {
	/**
	 * 标题
	 */
	private String Title;
	/**
	 * 描述
	 */
	private String Description;
	/**
	 * 链接
	 */
	private String Url;

	public LinkMessage(String title, String description, String url) {
		super();
		Title = title;
		Description = description;
		Url = url;
	}

}
