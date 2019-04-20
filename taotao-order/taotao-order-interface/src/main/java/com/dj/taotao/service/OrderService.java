package com.dj.taotao.service;

import com.dj.taotao.pojo.OrderInfo;
import com.dj.taotao.pojo.TaotaoResult;

public interface OrderService {
	
	TaotaoResult createOrder(OrderInfo orderInfo);

}
