package cn.xtesiro.mapps.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xtesiro.mapps.admin.vo.Menu;
import cn.xtesiro.mapps.admin.vo.MenuGroup;
import cn.xtesiro.mapps.common.entity.CommResc;
import cn.xtesiro.mapps.mapper.CommRescMapper;
import cn.xtesiro.mapps.utils.Constant;

@Service
public class MenuService {
	@Autowired
	CommRescMapper commRescMapper;

	/**
	 * 根据用户id获取菜单
	 * 
	 * @param userId
	 * @return
	 */
	public List<MenuGroup> getMenuByUserId(String userId) {
		List<MenuGroup> list = new ArrayList<MenuGroup>();
		List<CommResc> resList = commRescMapper.getMenuRescByUserId(userId);
		for (CommResc resc : resList) {
			if (Constant.RESC_MENUGROUP.equals(resc.getPresc())) {
				MenuGroup group = new MenuGroup(resc);
				group.setMenuList(getMenuListByGroup(group, resList));
				list.add(group);
			}
		}
		return list;
	}

	/**
	 * 根据角色id获取菜单
	 * 
	 * @param roleId
	 * @return
	 */
	public List<MenuGroup> getMenuByRoleId(String roleId) {
		List<MenuGroup> list = new ArrayList<MenuGroup>();
		List<CommResc> resList = commRescMapper.getMenuRescByRoleId(roleId);
		for (CommResc resc : resList) {
			if (Constant.RESC_MENUGROUP.equals(resc.getPresc())) {
				MenuGroup group = new MenuGroup(resc);
				group.setMenuList(getMenuListByGroup(group, resList));
				list.add(group);
			}
		}
		return list;
	}

	/**
	 * 获取二级菜单
	 * 
	 * @param group
	 * @param resList
	 * @return
	 */
	private List<Menu> getMenuListByGroup(MenuGroup group, List<CommResc> resList) {
		List<Menu> menuList = new ArrayList<Menu>();
		for (CommResc resc : resList) {
			if (!Constant.RESC_MENUGROUP.equals(resc.getPresc()) && resc.getPresc().equals(group.getId())) {
				menuList.add(new Menu(resc));
			}
		}
		return menuList;
	}
}
