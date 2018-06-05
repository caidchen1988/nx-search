package com.nx.search.wechat.entity.customer;

import lombok.Data;

/**
 * 多媒体类
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class Media {
	/**
	 * 媒体ID
	 */
	private String mediaId;
	
	public Media(String mediaId) {
		super();
		this.mediaId = mediaId;
	}
	
}
