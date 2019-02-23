package com.dj.taotao.pojo;

import java.io.Serializable;

/**
 * @ClassName: TbOrderItem
 * @Description: 订单商品
 * @author Steven
 * @date 2019年2月23日
 */
public class TbOrderItem implements Serializable {

	private static final long serialVersionUID = 9181624844629911789L;

	private String id;

	/**
	 * @Fields itemId : 商品id
	 */
	private String itemId;

	/**
	 * @Fields orderId : 订单id
	 */
	private String orderId;

	/**
	 * @Fields num : 商品购买数量
	 */
	private Integer num;

	/**
	 * @Fields title : 商品标题
	 */
	private String title;

	/**
	 * @Fields price : 商品单价
	 */
	private Long price;

	/**
	 * @Fields totalFee : 商品总金额
	 */
	private Long totalFee;

	/**
	 * @Fields picPath : 商品图片地址
	 */
	private String picPath;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId == null ? null : itemId.trim();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath == null ? null : picPath.trim();
	}
}