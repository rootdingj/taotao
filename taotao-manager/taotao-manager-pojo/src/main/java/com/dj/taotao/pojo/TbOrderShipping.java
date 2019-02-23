package com.dj.taotao.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbOrderShipping implements Serializable {
   
	private static final long serialVersionUID = 1836497534307954629L;

	/** 
	* @Fields orderId : 订单ID
	*/ 
	private String orderId;

    /** 
    * @Fields receiverName : 收货人全名
    */ 
    private String receiverName;

    /** 
    * @Fields receiverPhone : 固定电话 
    */ 
    private String receiverPhone;

    /** 
    * @Fields receiverMobile : 移动电话
    */ 
    private String receiverMobile;

    /** 
    * @Fields receiverState : 省份
    */ 
    private String receiverState;

    /** 
    * @Fields receiverCity : 城市
    */ 
    private String receiverCity;

    /** 
    * @Fields receiverDistrict : 区/县
    */ 
    private String receiverDistrict;

    /** 
    * @Fields receiverAddress : 收货地址，如：xx路xx号
    */ 
    private String receiverAddress;

    /** 
    * @Fields receiverZip : 邮政编码,如：310001
    */ 
    private String receiverZip;

    /** 
    * @Fields created : 创建时间
    */ 
    private Date created;

    /** 
    * @Fields updated : 更新时间
    */ 
    private Date updated;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
    }

    public String getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState == null ? null : receiverState.trim();
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity == null ? null : receiverCity.trim();
    }

    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict == null ? null : receiverDistrict.trim();
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip == null ? null : receiverZip.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}