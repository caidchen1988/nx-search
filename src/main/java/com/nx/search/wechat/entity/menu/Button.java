package com.nx.search.wechat.entity.menu;

import lombok.Data;

/**
 * 按钮
 * 
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class Button {

	/**
	 * 按钮名称
	 */
	private String name;

	/**
	 * 按钮类型
	 */
	private String type;

	/**
	 * 按钮key值
	 */
	private String key;

	/**
	 * 按钮url
	 */
	private String url;

	/**
	 * 子按钮列表
	 */
	private Button[] sub_button;

	public Button(String name, String type, String key, String url,
			Button[] sub_button) {
		super();
		this.name = name;
		this.type = type;
		this.key = key;
		this.url = url;
		this.sub_button = sub_button;
	}

	public Button() {
		super();
	}

}
