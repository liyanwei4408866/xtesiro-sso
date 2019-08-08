package cn.xtesiro.mapps.admin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xtesiro.mapps.admin.response.MenuResponse;
import cn.xtesiro.mapps.admin.service.MenuService;
import cn.xtesiro.mapps.sso.vo.UserInfo;

@RestController
public class MenuController {

	protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
	@Autowired
	MenuService menuService;

	/**
	 * 查询登录人可见菜单
	 * 
	 * @return
	 */
	@GetMapping(value = "/menu")
	public MenuResponse selectAll() {
		MenuResponse res = new MenuResponse();
		Subject currentUser = SecurityUtils.getSubject();
		UserInfo userInfo = (UserInfo) currentUser.getPrincipal();
		System.out.println(userInfo.toString());
		try {
			res.setMenuGroupList(menuService.getMenuByUserId(userInfo.getUserid()));
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("登录人:{},菜单获取异常{}", userInfo.getDescn(), e);
		}
		return res;
	}
}
