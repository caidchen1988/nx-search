package com.nx.search.wechat.entity.customer;

import lombok.Data;

/**
 * 音乐消息
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class MusicMessage extends CustomerBaseMessage{
	
	/**
	 * 音乐对象
	 */
	private Music music;

	public MusicMessage(Music music) {
		super();
		this.music = music;
	}

	public MusicMessage() {
		super();
	}
	
}
