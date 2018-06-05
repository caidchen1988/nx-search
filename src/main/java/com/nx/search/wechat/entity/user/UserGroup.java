package com.nx.search.wechat.entity.user;

import lombok.Data;

/**
 * 用户分组
 * @author caspar.chen
 * @version 1.0
 */
@Data
public class UserGroup {

	/**
	 * 分组id，由微信分配
	 */
	private String id;
	/**
	 * 分组名字，UTF8编码
	 */
	private String name;
	/**
	 * 分组内用户数量
	 */
	private int count;
	
	public UserGroup(String id, String name, int count) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
	}
	public UserGroup() {
		super();
	}
	
}
