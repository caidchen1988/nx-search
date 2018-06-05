package com.nx.search.wechat.entity.message.resp;

import lombok.Data;

/**
 * 音乐消息
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class MusicMessage extends BaseMessage {
	/**
	 * 音乐名称
	 */
	private String title;
	
	/**
	 * 音乐描述
	 */
	private String description;
	
	/**
	 * 音乐链接
	 */
	private String musicUrl;
	
	/**
	 * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 */
	private String hQMusicUrl;
	
	/**
	 * 缩略图的媒体id，通过上传多媒体文件，得到的id
	 */
	private String thumbMediaId;

	public MusicMessage(String title, String description, String musicUrl,
			String hQMusicUrl, String thumbMediaId) {
		super();
		this.title = title;
		this.description = description;
		this.musicUrl = musicUrl;
		this.hQMusicUrl = hQMusicUrl;
		this.thumbMediaId = thumbMediaId;
	}

	public MusicMessage() {
		super();
	}
	
}