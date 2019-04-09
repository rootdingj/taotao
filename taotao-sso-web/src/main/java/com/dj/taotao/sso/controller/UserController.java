package com.dj.taotao.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dj.taotao.pojo.TaotaoResult;
import com.dj.taotao.pojo.TbUser;
import com.dj.taotao.sso.service.UserService;
import com.dj.taotao.utils.CookieUtils;

/**
 * 
 * @ClassName: UserController
 * @Description: 用户管理Controller
 * @author Steven
 * @date 2019年4月7日
 */
@Controller
public class UserController {
	
	@Value("${TOKEN_KEY}")
	private String TOKEN_KEY;

	@Autowired	
	private UserService userService;

	@RequestMapping("/user/check/{param}/{type}")
	@ResponseBody
	public TaotaoResult checkUserData(@PathVariable String param, @PathVariable Integer type) {

		return userService.checkData(param, type);
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult register(TbUser user) {

		return userService.register(user);
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	@ResponseBody
	public TaotaoResult login(String username, String password, HttpServletRequest request,
			HttpServletResponse response) {
		TaotaoResult result = userService.login(username, password);
		// 登录成功后写cookie
		if (result.getStatus() == 200) {
			// 把token写入cookie
			CookieUtils.setCookie(request, response, TOKEN_KEY, result.getData().toString());
		}
		return result;
	}

}
