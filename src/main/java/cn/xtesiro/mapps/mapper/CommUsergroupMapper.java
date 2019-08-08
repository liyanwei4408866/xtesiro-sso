package cn.xtesiro.mapps.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.xtesiro.mapps.admin.vo.Usergroup;
import cn.xtesiro.mapps.common.entity.CommUsergroup;
import cn.xtesiro.mapps.common.mybatis.IBaseDao;

public interface CommUsergroupMapper extends IBaseDao<CommUsergroup> {
	@Select("select a.id usergroupid,a.groupname,group_concat(c.descn separator ',') rolename "
		  + "from comm_usergroup a ,comm_usergrp_role b,comm_role c "
		  + "where a.isdelete = 0 "
		  + "  and a.id = b.usergrp_id "
		  + "  and b.role_id = c.id "
		  + "group by a.id,a.groupname ")
	List<Usergroup> getAll();

	List<Usergroup> getList();
}