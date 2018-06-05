package com.nx.search.wechat.entity.message.resp;

import lombok.Data;

/**
 * 多媒体消息<br>
 * 图片消息、语音消息直接用此类
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class MediaMessage extends BaseMessage{
	/**
	 * 通过上传多媒体文件，得到的id
	 */
	private String mediaId;

}
