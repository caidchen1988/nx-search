package com.nx.search.wechat.entity.customer;

import lombok.Data;

/**
 * 发送客服消息基类
 * @author caspar.chen
 * @version 1.0
 */
@Data
public class CustomerBaseMessage {
	
	/**
	 * 普通用户openid
	 */
	private String touser;
	
	/**
	 * 消息类型
	 */
	private String msgtype;

}
