package cn.xtesiro.mapps.sso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xtesiro.mapps.admin.service.MenuService;
import cn.xtesiro.mapps.admin.service.RoleService;
import cn.xtesiro.mapps.common.entity.CommUser;
import cn.xtesiro.mapps.mapper.CommUserMapper;
import cn.xtesiro.mapps.sso.vo.UserInfo;

@Service
public class UserService {
	@Autowired
	private CommUserMapper userInfoService;
	@Autowired
	MenuService menuService;
	@Autowired
	RoleService roleService;

	public UserInfo getUserInfoByUserName(String username) {
		CommUser commUser = new CommUser();
		commUser.setUsername(username);
		commUser.setIsDelete("0");
		commUser = userInfoService.selectOne(commUser);
		if (commUser == null) {
			return null;
		}
		UserInfo user = new UserInfo(commUser);
		user.setMenuList(menuService.getMenuByUserId(user.getUserid()));
		user.setRoleList(roleService.getRoleByUserId(user.getUserid()));
		return user;
	}
}
