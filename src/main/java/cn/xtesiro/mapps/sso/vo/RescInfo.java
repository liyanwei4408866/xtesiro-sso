package cn.xtesiro.mapps.sso.vo;

import java.io.Serializable;

public class RescInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String rescid;
	private String descn;
	private String name;
	private String presc;
	private String priority;
	private String resCode;
	private String resString;
	private String resType;

	public String getRescid() {
		return rescid;
	}

	public void setRescid(String rescid) {
		this.rescid = rescid;
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

	public String getPresc() {
		return presc;
	}

	public void setPresc(String presc) {
		this.presc = presc;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getResString() {
		return resString;
	}

	public void setResString(String resString) {
		this.resString = resString;
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}
}
