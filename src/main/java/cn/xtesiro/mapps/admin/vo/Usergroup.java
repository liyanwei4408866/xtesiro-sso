package cn.xtesiro.mapps.admin.vo;

import java.io.Serializable;

public class Usergroup implements Serializable {
	private static final long serialVersionUID = 1L;
	private String usergroupid;
	private String groupname;
	private String isdelete;
	private String rolename;

	public String getUsergroupid() {
		return usergroupid;
	}

	public void setUsergroupid(String usergroupid) {
		this.usergroupid = usergroupid;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
