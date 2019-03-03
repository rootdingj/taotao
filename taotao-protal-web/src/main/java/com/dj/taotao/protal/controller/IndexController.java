package com.dj.taotao.protal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @ClassName: IndexController 
 * @Description: 首页展示Controller 
 * @author Steven 
 * @date 2019年3月3日
 */
@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public String showIndex() {
		return "index";
	}
	
	

}
