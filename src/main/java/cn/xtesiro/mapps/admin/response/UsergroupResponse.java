package cn.xtesiro.mapps.admin.response;

import java.util.List;

import cn.xtesiro.mapps.admin.vo.Usergroup;
import cn.xtesiro.mapps.common.response.BaseResponse;

public class UsergroupResponse extends BaseResponse {

	private long total;
	private List<Usergroup> usergroupList;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<Usergroup> getUsergroupList() {
		return usergroupList;
	}

	public void setUsergroupList(List<Usergroup> usergroupList) {
		this.usergroupList = usergroupList;
	}


}
