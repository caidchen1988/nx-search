package com.nx.search.wechat.entity;

import lombok.Data;

/**
 * 二维码
 * @author caspar.chen
 * @version 1.0
 */
@Data
public class QRcode {
	/**
	 * 该二维码有效时间，以秒为单位。 最大不超过1800
	 */
	private String expireSeconds;
	
	/**
	 * 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久
	 */
	private String actionName;
	
	/**
	 * 二维码详细信息
	 */
	private String actionInfo;
	
	/**
	 * 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 */
	private String sceneId;
	
	/**
	 * 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
	 */
	private String ticket;

	public QRcode(String expireSeconds, String actionName, String actionInfo,
			String sceneId, String ticket) {
		super();
		this.expireSeconds = expireSeconds;
		this.actionName = actionName;
		this.actionInfo = actionInfo;
		this.sceneId = sceneId;
		this.ticket = ticket;
	}

	public QRcode() {
		super();
	}

}
