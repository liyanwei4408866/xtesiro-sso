package cn.xtesiro.mapps.response;

import java.util.List;

import cn.xtesiro.mapps.admin.vo.MenuGroup;
import cn.xtesiro.mapps.common.response.BaseResponse;
import cn.xtesiro.mapps.sso.vo.RoleInfo;

public class LoginResponse extends BaseResponse {
	private String token;
	private String descn;
	private String userGroupId;
	private List<RoleInfo> roleList;
	private List<MenuGroup> menuList;

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public String getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}

	public List<RoleInfo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleInfo> roleList) {
		this.roleList = roleList;
	}

	public List<MenuGroup> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuGroup> menuList) {
		this.menuList = menuList;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
