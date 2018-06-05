package com.nx.search.wechat.entity.menu;

import lombok.Data;

/**
 * 菜单
 * @author caspar.chen
 * @version 1.0
 * 
 */
@Data
public class Menu {
	
	/**
	 * 菜单按钮
	 */
	private Button[] button;

	public Menu(Button[] button) {
		super();
		this.button = button;
	}

	public Menu() {
		super();
	}  
}
