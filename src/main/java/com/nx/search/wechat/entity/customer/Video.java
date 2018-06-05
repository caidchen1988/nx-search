package com.nx.search.wechat.entity.customer;

import lombok.Data;

/**
 * 视频消息对象
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class Video {
	/**
	 * 视频消息的标题
	 */
	private String title;
	
	/**
	 * 视频消息的描述
	 */
	private String description;
	
	public Video(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public Video() {
		super();
	}
	
}
