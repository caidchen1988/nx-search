package com.nx.search.wechat.entity.message.req;

import lombok.Data;

/**
 * 图片消息
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class ImageMessage extends MediaMessage{

	/**
	 * 图片链接
	 */
	private String picUrl;

	public ImageMessage(String picUrl) {
		super();
		this.picUrl = picUrl;
	}
	
}
