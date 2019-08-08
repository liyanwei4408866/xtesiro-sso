package cn.xtesiro.mapps.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xtesiro.mapps.common.entity.CommRole;
import cn.xtesiro.mapps.mapper.CommRoleMapper;
import cn.xtesiro.mapps.sso.vo.RoleInfo;

@Service
public class RoleService {
	@Autowired
	CommRoleMapper commRoleMapper;
	@Autowired
	MenuService menuService;

	public List<RoleInfo> getRoleByUserId(String userId) {
		List<RoleInfo> roleList = new ArrayList<RoleInfo>();
		List<CommRole> list = commRoleMapper.getCommRoleByUserId(userId);
		for (CommRole entity : list) {
			RoleInfo role = new RoleInfo(entity);
			role.setMenuList(menuService.getMenuByRoleId(entity.getId()));
			roleList.add(role);
		}
		return roleList;
	}

	public CommRoleMapper getCommRoleMapper() {
		return commRoleMapper;
	}

}
