package com.dj.taotao.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TbOrder
 * @Description: 订单
 * @author Steven
 * @date 2019年2月23日
 */
public class TbOrder implements Serializable {

	private static final long serialVersionUID = 7516973762191666040L;

	/**
	 * @Fields orderId : 订单id
	 */
	private String orderId;

	/**
	 * @Fields payment : 实付金额(单位:元。精确到2位小数,如:200.07,表示:200元7分。金额通用格式)
	 */
	private String payment;

	/**
	 * @Fields paymentType : 支付类型(1:在线支付，2:货到付款)
	 */
	private Integer paymentType;

	/**
	 * @Fields postFee : 邮费
	 */
	private String postFee;

	/**
	 * @Fields status : 状态(1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭)
	 */
	private Integer status;

	/**
	 * @Fields createTime : 订单创建时间
	 */
	private Date createTime;

	/**
	 * @Fields updateTime : 订单更新时间
	 */
	private Date updateTime;

	/**
	 * @Fields paymentTime : 付款时间
	 */
	private Date paymentTime;

	/**
	 * @Fields consignTime : 发货时间
	 */
	private Date consignTime;

	/**
	 * @Fields endTime : 交易完成时间
	 */
	private Date endTime;

	/**
	 * @Fields closeTime : 交易关闭时间
	 */
	private Date closeTime;

	/**
	 * @Fields shippingName : 物流名称
	 */
	private String shippingName;

	/**
	 * @Fields shippingCode : 物流单号
	 */
	private String shippingCode;

	/**
	 * @Fields userId : 用户id
	 */
	private Long userId;

	/**
	 * @Fields buyerMessage : 买家留言
	 */
	private String buyerMessage;

	/**
	 * @Fields buyerNick : 买家昵称
	 */
	private String buyerNick;

	/**
	 * @Fields buyerRate : 买家是否已经评价
	 */
	private Integer buyerRate;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment == null ? null : payment.trim();
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public String getPostFee() {
		return postFee;
	}

	public void setPostFee(String postFee) {
		this.postFee = postFee == null ? null : postFee.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Date getConsignTime() {
		return consignTime;
	}

	public void setConsignTime(Date consignTime) {
		this.consignTime = consignTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName == null ? null : shippingName.trim();
	}

	public String getShippingCode() {
		return shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode == null ? null : shippingCode.trim();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getBuyerMessage() {
		return buyerMessage;
	}

	public void setBuyerMessage(String buyerMessage) {
		this.buyerMessage = buyerMessage == null ? null : buyerMessage.trim();
	}

	public String getBuyerNick() {
		return buyerNick;
	}

	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick == null ? null : buyerNick.trim();
	}

	public Integer getBuyerRate() {
		return buyerRate;
	}

	public void setBuyerRate(Integer buyerRate) {
		this.buyerRate = buyerRate;
	}
}