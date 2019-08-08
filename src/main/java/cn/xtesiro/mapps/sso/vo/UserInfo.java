package cn.xtesiro.mapps.sso.vo;

import java.io.Serializable;
import java.util.List;

import cn.xtesiro.mapps.admin.vo.MenuGroup;
import cn.xtesiro.mapps.common.entity.CommUser;

public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userid;
	private String username;
	private String password;
	/**
	 * 中文名
	 */
	private String descn;
	private String status;
	private String isDelete;
	private String userGroupId;
	private String pinyin;

	private List<RoleInfo> roleList;
	private List<MenuGroup> menuList;

	public UserInfo() {
	}

	public UserInfo(CommUser user) {
		this.setUserInfo(user);
	}
	public void setUserInfo(CommUser user) {
		if (user != null) {
			this.setUserid(user.getId());
			this.setUsername(user.getUsername());
			this.setPassword(user.getPassword());
			this.setDescn(user.getDescn());
			this.setStatus(user.getStatus());
			this.setIsDelete(user.getIsDelete());
			this.setUserGroupId(user.getUserGroupId());
			this.setPinyin(user.getPinyin());
		}
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", USER_ID=").append(userid);
		sb.append(", USER_NAME=").append(username);
		sb.append(", USER_PASSWORD=").append(password);
		sb.append(", descn=").append(descn);
		sb.append("]");
		return sb.toString();
	}
}
