package com.nx.search.wechat.entity.message.req;

import lombok.Data;

/**
 * 视频消息
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class VideoMessage extends BaseMessage{
	
	/**
	 * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
	 */
	private String thumbMediaId;

	public VideoMessage(String thumbMediaId) {
		super();
		this.thumbMediaId = thumbMediaId;
	}
	
	
}
