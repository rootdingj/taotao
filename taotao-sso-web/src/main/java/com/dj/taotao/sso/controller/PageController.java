package com.dj.taotao.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @ClassName: PageController 
 * @Description: 展示登录和注册页面的Controller
 * @author Steven 
 * @date 2019年4月10日
 */
@Controller
public class PageController {
	
	@RequestMapping("/page/register")
	public String showRegister() {
		return "register";
	}
	@RequestMapping("/page/login")
	public String showLogin() {
		return "login";
	}

}
