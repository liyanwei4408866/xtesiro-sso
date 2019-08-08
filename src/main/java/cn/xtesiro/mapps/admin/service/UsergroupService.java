package cn.xtesiro.mapps.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.xtesiro.mapps.admin.vo.Usergroup;
import cn.xtesiro.mapps.common.entity.CommUsergroup;
import cn.xtesiro.mapps.mapper.CommUsergroupMapper;
import cn.xtesiro.mapps.mapper.CommUsergrpRoleMapper;
import cn.xtesiro.mapps.utils.Constant;
import cn.xtesiro.mapps.utils.IDGen;

@Service
public class UsergroupService {
	@Autowired
	CommUsergroupMapper commUsergroupMapper;
	@Autowired
	CommUsergrpRoleMapper commUsergrpRoleMapper;

	public void createUserGroup(String name) {
		CommUsergroup entity = new CommUsergroup();
		entity.setId(IDGen.uuid());
		entity.setGroupName(name);
		entity.setIsDelete(Constant.DATA_ACTIVE);
		commUsergroupMapper.insert(entity);
	}

	public PageInfo<CommUsergroup> getUserGroupForPage(int current, int display) {
		PageHelper.startPage(current, display);
		List<CommUsergroup> list = commUsergroupMapper.selectAll();
		PageInfo<CommUsergroup> page = new PageInfo<CommUsergroup>(list);
		return page;
	}

	public PageInfo<Usergroup> getUserGroupAndRoleForPage(int current, int display) {
		PageHelper.startPage(current, display);
		List<Usergroup> list = commUsergroupMapper.getList();
		PageInfo<Usergroup> page = new PageInfo<Usergroup>(list);
		return page;
	}

	public CommUsergroupMapper getCommUsergroupMapper() {
		return commUsergroupMapper;
	}
}
