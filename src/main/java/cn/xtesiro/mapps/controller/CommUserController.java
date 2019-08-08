package cn.xtesiro.mapps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.xtesiro.mapps.common.entity.CommUser;
import cn.xtesiro.mapps.common.request.BaseRequest;
import cn.xtesiro.mapps.mapper.CommUserMapper;
import cn.xtesiro.mapps.response.GetResponse;

@RestController
public class CommUserController {

	@Autowired
	CommUserMapper commUserMapper;

	@GetMapping(value = "/user")
	public GetResponse selectAll(BaseRequest req) {
		GetResponse res = new GetResponse();
		System.out.println(req.toString());
//        PageHelper.startPage(req.getCurrent(), req.getDisplay());
		PageHelper.startPage(1, 10);
		List<CommUser> list = commUserMapper.selectAll();
		PageInfo<CommUser> page = new PageInfo<CommUser>(list);
		res.setTotal(page.getTotal());
		res.setOaUserList(list);
		return res;
	}
}
