package com.dj.taotao.pojo;

import java.io.Serializable;
import java.util.List;

import com.dj.taotao.pojo.TbOrder;
import com.dj.taotao.pojo.TbOrderItem;
import com.dj.taotao.pojo.TbOrderShipping;

public class OrderInfo extends TbOrder implements Serializable {

	private List<TbOrderItem> orderItems;
	private TbOrderShipping orderShipping;

	public List<TbOrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<TbOrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}

	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}

}
