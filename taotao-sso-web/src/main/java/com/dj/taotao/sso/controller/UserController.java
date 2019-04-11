package com.dj.taotao.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dj.taotao.pojo.TaotaoResult;
import com.dj.taotao.pojo.TbUser;
import com.dj.taotao.sso.service.UserService;
import com.dj.taotao.utils.CookieUtils;
import com.dj.taotao.utils.JsonUtils;

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

	/*
	 * @RequestMapping(value = "/user/token/{token}", method = RequestMethod.GET, //
	 * 指定返回响应数据的content-type produces = MediaType.APPLICATION_JSON_VALUE)
	 * 
	 * @ResponseBody public String getUserByToken(@PathVariable String token,String
	 * callback) { TaotaoResult result = userService.getUserByToken(token);
	 * //判断是否为jsonp请求 if (StringUtils.isNotBlank(callback)) { return callback + "("
	 * + JsonUtils.objectToJson(result) + ");"; } return
	 * JsonUtils.objectToJson(result); }
	 */

	// jsonp的第二种方法，spring4.1以上版本使用
	@RequestMapping(value = "/user/token/{token}", method = RequestMethod.GET)
	@ResponseBody
	public Object getUserByToken(@PathVariable String token, String callback) {
		TaotaoResult result = userService.getUserByToken(token);
		// 判断是否为jsonp请求
		if (StringUtils.isNotBlank(callback)) {
			MappingJacksonValue value = new MappingJacksonValue(result);
			// 设置回调方法
			value.setJsonpFunction(callback);
			return value;
		}
		return result;
	}

}
