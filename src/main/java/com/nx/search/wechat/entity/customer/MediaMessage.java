package com.nx.search.wechat.entity.customer;

import lombok.Data;

/**
 * 媒体类， 图片/语音可直接用此类
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class MediaMessage extends CustomerBaseMessage{
	
	/**
	 * 媒体对象
	 */
	private Media media;

	public MediaMessage(Media media) {
		super();
		this.media = media;
	}

	public MediaMessage() {
		super();
	}
	
}
