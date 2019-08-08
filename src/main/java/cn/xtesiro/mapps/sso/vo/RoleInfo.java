package cn.xtesiro.mapps.sso.vo;

import java.io.Serializable;
import java.util.List;

import cn.xtesiro.mapps.admin.vo.MenuGroup;
import cn.xtesiro.mapps.common.entity.CommRole;

public class RoleInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String roleid;
	private String descn;
	private String name;
	private List<MenuGroup> menuList;

	public RoleInfo() {
	}

	public RoleInfo(CommRole role) {
		if (role != null) {
			this.setRoleid(role.getId());
			this.setName(role.getName());
			this.setDescn(role.getDescn());
		}
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MenuGroup> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MenuGroup> menuList) {
		this.menuList = menuList;
	}

}
