package com.nx.search.wechat.entity.message.req;

import lombok.Data;

/**
 * 地理位置消息
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class LocationMessage extends BaseMessage {
	/**
	 * 地理位置维度
	 */
	private String Location_X;
	/**
	 * 地理位置经度
	 */
	private String Location_Y;

	/**
	 * 地图缩放大小
	 */
	private String Scale;

	/**
	 * 地理位置信息
	 */
	private String Label;

	public LocationMessage(String location_X, String location_Y, String scale,
			String label) {
		super();
		Location_X = location_X;
		Location_Y = location_Y;
		Scale = scale;
		Label = label;
	}

}
