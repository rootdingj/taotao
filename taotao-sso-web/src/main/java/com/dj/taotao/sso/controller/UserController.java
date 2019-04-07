package com.dj.taotao.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dj.taotao.pojo.TaotaoResult;
import com.dj.taotao.pojo.TbUser;
import com.dj.taotao.sso.service.UserService;

/**
 * 
 * @ClassName: UserController
 * @Description: 用户管理Controller
 * @author Steven
 * @date 2019年4月7日
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/check/{param}/{type}")
	@ResponseBody
	public TaotaoResult checkUserData(@PathVariable String param, @PathVariable Integer type) {

		return userService.checkData(param, type);
	}

	@RequestMapping("/user/register")
	@ResponseBody
	public TaotaoResult register(TbUser user) {
		
		return userService.register(user);
	}

}
