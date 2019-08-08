package cn.xtesiro.mapps.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.xtesiro.mapps.common.entity.CommUser;
import cn.xtesiro.mapps.common.response.BaseResponse;
import cn.xtesiro.mapps.response.LoginResponse;
import cn.xtesiro.mapps.service.LoginService;
import cn.xtesiro.mapps.sso.vo.UserInfo;

@RestController
public class LoginController {
	@Autowired
	LoginService loginService;

	@GetMapping(value = "/login")
	public LoginResponse login() {
		LoginResponse res = new LoginResponse();
		setLoginResponse(res);
		return res;
	}

	@PostMapping(value = "/ajaxLogin")
	public LoginResponse ajaxLogin(@RequestBody CommUser userInfo) {
		LoginResponse res = new LoginResponse();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
		try {
			subject.login(token);
			res.success();
			res.setToken((String) subject.getSession().getId());
			UserInfo currentUser = (UserInfo) subject.getPrincipal();
			res.setDescn(currentUser.getDescn());
			res.setUserGroupId(currentUser.getUserGroupId());
			res.setMenuList(currentUser.getMenuList());
			res.setRoleList(currentUser.getRoleList());
		} catch (IncorrectCredentialsException e) {
			res.fail("密码错误");
		} catch (LockedAccountException e) {
			res.fail("登录失败，该用户已被冻结");
		} catch (AuthenticationException e) {
			res.fail("该用户不存在");
		} catch (Exception e) {
			res.fail("登录异常");
			e.printStackTrace();
		}
		return res;
	}

	private void setLoginResponse(LoginResponse res) {
		Subject subject = SecurityUtils.getSubject();
		UserInfo currentUser = (UserInfo) subject.getPrincipal();
		if (currentUser == null) {
			res.fail();
		}
		res.setDescn(currentUser.getDescn());
		res.setUserGroupId(currentUser.getUserGroupId());
		res.setMenuList(currentUser.getMenuList());
		res.setRoleList(currentUser.getRoleList());
	}

	/**
	 * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/unauth")
	@ResponseBody
	public LoginResponse unauth() {
		LoginResponse res = new LoginResponse();
		res.fail("未登录");
		return res;
	}

	@GetMapping(value = "/logout")
	public BaseResponse logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return new BaseResponse();
	}
}
