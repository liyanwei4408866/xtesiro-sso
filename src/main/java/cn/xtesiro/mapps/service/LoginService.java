package cn.xtesiro.mapps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.xtesiro.mapps.common.entity.CommUser;
import cn.xtesiro.mapps.mapper.CommUserMapper;
import tk.mybatis.mapper.entity.Example;

@Service
public class LoginService {
	@Autowired
	RedisService redisService;
	@Autowired
	CommUserMapper commUserMapper;

	public CommUser login(String loginCode, String password) {
		CommUser user = null;
		String userJson = redisService.get(loginCode);
		// 缓存没有数据
		if (userJson == null) {
			Example example = new Example(CommUserMapper.class);
			example.createCriteria().andEqualTo("loginCode", loginCode);
			user = commUserMapper.selectOneByExample(example);
			String pwd = DigestUtils.md5DigestAsHex(password.getBytes());
			if (pwd.equals(user.getPassword())) {
				try {
//					redisService.put(loginCode, "MapperUtils.obj2json(user)", 60 * 60 * 24);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return user;
			}
			else {
				return null;
			}
		}
		else {
			try {
				user = new CommUser();// "MapperUtils.json2pojo(userJson,CommUser.class);";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return user;
	}
}
