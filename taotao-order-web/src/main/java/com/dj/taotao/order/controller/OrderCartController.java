package com.dj.taotao.order.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dj.taotao.pojo.TbItem;
import com.dj.taotao.pojo.TbUser;
import com.dj.taotao.utils.CookieUtils;
import com.dj.taotao.utils.JsonUtils;

/** 
 * @ClassName: OrderCartController 
 * @Description: 订单确认页面处理Controller
 * @author Steven 
 * @date 2019年4月13日  
 */
@Controller
public class OrderCartController {
	
	@Value("${CART_KEY}")
	private String CART_KEY;
	
	@RequestMapping("/order/order-cart")
	public String showOrderCart(HttpServletRequest request) {
		//用户必须是登录状态
		//取用户id
		TbUser user = (TbUser) request.getAttribute("user");
		System.out.println(user.getUsername());
		// TODO根据用户信息取收货地址列表，使用静态数据。
		//把收货地址列表取出传递给页面
		//从cookie中取购物车商品列表展示到页面
		List<TbItem> cartList = getCartItemList(request);
		request.setAttribute("cartList", cartList);
		return "order-cart";
	}
	
	private List<TbItem> getCartItemList(HttpServletRequest request) {
		//从cookie中取购物车商品列表
		String json = CookieUtils.getCookieValue(request, CART_KEY, true);
		if (StringUtils.isBlank(json)) {
			return new ArrayList<>();
		}
		List<TbItem> list = JsonUtils.jsonToList(json, TbItem.class);
		return list;
	}

}
