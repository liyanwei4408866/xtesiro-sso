package cn.xtesiro.mapps.admin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;

import cn.xtesiro.mapps.admin.response.UsergroupResponse;
import cn.xtesiro.mapps.admin.service.UsergroupService;
import cn.xtesiro.mapps.admin.vo.Usergroup;
import cn.xtesiro.mapps.common.entity.CommUsergroup;
import cn.xtesiro.mapps.common.request.BaseRequest;
import cn.xtesiro.mapps.sso.vo.UserInfo;
import cn.xtesiro.mapps.utils.LogUtil;

@RestController
public class UsergroupController {
	protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
	@Autowired
	UsergroupService usergroupService;

	@PostMapping(value = "/usergroup")
	public UsergroupResponse create(@RequestBody CommUsergroup req) {
		UsergroupResponse res = new UsergroupResponse();
		if (StringUtil.isEmpty(req.getGroupName())) {
			res.fail();
			LOGGER.error("用户组创建失败:组名缺失");
			return res;
		}
		try {
			usergroupService.createUserGroup(req.getGroupName());
		} catch (Exception e) {
			res.fail();
			LOGGER.error("用户组创建失败:{}", e);
		}
		return res;
	}

	@PutMapping(value = "/usergroup/{id}")
	public UsergroupResponse updateByPrimaryKey(@PathVariable String id, BaseRequest req) {
		UsergroupResponse res = new UsergroupResponse();
		if (StringUtil.isEmpty(id)) {
			res.fail();
			LOGGER.error("用户组修改失败:id缺失");
			return res;
		}
		if (StringUtil.isEmpty(req.getName())) {
			res.fail();
			LOGGER.error("用户组修改失败:组名缺失");
			return res;
		}
		try {
			CommUsergroup entity = new CommUsergroup();
			entity.setId(id);
			entity.setGroupName(req.getName());
			usergroupService.getCommUsergroupMapper().updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			res.fail();
			LOGGER.error("用户组修改失败:{}", e);
		}
		return res;
	}

	@PutMapping(value = "/usergroup/{id}/role")
	public UsergroupResponse updateRoleByPrimaryKey(@PathVariable String id, BaseRequest req) {
		UsergroupResponse res = new UsergroupResponse();
		if (StringUtil.isEmpty(id)) {
			res.fail();
			LOGGER.error("用户组修改失败:id缺失");
			return res;
		}
		if (StringUtil.isEmpty(req.getName())) {
			res.fail();
			LOGGER.error("用户组修改失败:组名缺失");
			return res;
		}
		try {
			CommUsergroup entity = new CommUsergroup();
			entity.setId(id);
			entity.setGroupName(req.getName());
			usergroupService.getCommUsergroupMapper().updateByPrimaryKeySelective(entity);
		} catch (Exception e) {
			res.fail();
			LOGGER.error("用户组修改失败:{}", e);
		}
		return res;
	}

	@DeleteMapping(value = "/usergroup/{id}")
	public UsergroupResponse deleteByPrimaryKey(@PathVariable String id) {
		UsergroupResponse res = new UsergroupResponse();
		if (StringUtil.isEmpty(id)) {
			res.fail();
			LOGGER.error("用户组删除失败:ID缺失");
			return res;
		}
		try {
			usergroupService.getCommUsergroupMapper().deleteByPrimaryKey(id);
		} catch (Exception e) {
			res.fail();
			LOGGER.error("用户组删除失败:{}", e);
		}
		return res;
	}

	/**
	 * 查询用户组
	 * 
	 * @return
	 */
	@GetMapping(value = "/usergroup")
	public UsergroupResponse selectAll(BaseRequest req) {
		LOGGER.info("查询用户组:" + LogUtil.getObjectInfo(req));
		UsergroupResponse res = new UsergroupResponse();
		Subject currentUser = SecurityUtils.getSubject();
		UserInfo userInfo = (UserInfo) currentUser.getPrincipal();
		System.out.println(userInfo.toString());
		try {
			PageInfo<Usergroup> page = usergroupService.getUserGroupAndRoleForPage(req.getCurrent(), req.getDisplay());
			res.setTotal(page.getTotal());
			res.setUsergroupList(page.getList());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("登录人:{},用户组获取异常{}", userInfo.getDescn(), e);
		}
		return res;
	}
}
