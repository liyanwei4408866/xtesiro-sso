package cn.xtesiro.mapps.admin.response;

import java.util.List;

import cn.xtesiro.mapps.admin.vo.MenuGroup;
import cn.xtesiro.mapps.common.response.BaseResponse;

public class MenuResponse extends BaseResponse {
	private List<MenuGroup> menuGroupList;

	public List<MenuGroup> getMenuGroupList() {
		return menuGroupList;
	}

	public void setMenuGroupList(List<MenuGroup> menuGroupList) {
		this.menuGroupList = menuGroupList;
	}

}
