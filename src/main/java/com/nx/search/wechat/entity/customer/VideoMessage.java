package com.nx.search.wechat.entity.customer;

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
	 * 视频消息对象
	 */
	private Video video;

	public VideoMessage(Video video) {
		super();
		this.video = video;
	}

	public VideoMessage() {
		super();
	}

}
