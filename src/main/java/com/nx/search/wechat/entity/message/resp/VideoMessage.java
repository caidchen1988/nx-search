package com.nx.search.wechat.entity.message.resp;

import lombok.Data;

/**
 * 视频消息
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class VideoMessage extends MediaMessage{
	/**
	 * 视频消息的标题
	 */
	private String title;
	
	/**
	 * 视频消息的描述
	 */
	private String description;

	public VideoMessage(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public VideoMessage() {
		super();
	}
	
	
}
