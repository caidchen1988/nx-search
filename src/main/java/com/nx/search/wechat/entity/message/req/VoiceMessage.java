package com.nx.search.wechat.entity.message.req;

import lombok.Data;

/**
 * 语音消息
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class VoiceMessage extends BaseMessage {
	/**
	 * 语音格式，如amr，speex等
	 */
	private String Format;

	public VoiceMessage(String format) {
		super();
		Format = format;
	}

}
