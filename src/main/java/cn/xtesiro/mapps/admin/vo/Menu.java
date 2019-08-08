package cn.xtesiro.mapps.admin.vo;

import java.io.Serializable;

import cn.xtesiro.mapps.common.entity.CommResc;

public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String descn;

	private String name;

	private String presc;

	private String priority;

	private String resCode;

	private String resString;

	private String resType;

	public Menu() {
	}

	public Menu(CommResc resc) {
		if (resc != null) {
			this.setId(resc.getId());
			this.setDescn(resc.getDescn());
			this.setName(resc.getName());
			this.setPresc(resc.getPresc());
			this.setPriority(resc.getPriority());
			this.setResCode(resc.getResCode());
			this.setResString(resc.getResString());
			this.setResType(resc.getResType());
		}
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
