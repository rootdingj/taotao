package com.dj.taotao.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TbItemParam
 * @Description: 商品规则参数
 * @author Steven
 * @date 2019年2月23日
 */
public class TbItemParam implements Serializable {

	private static final long serialVersionUID = 6710367662390898884L;

	/**
	 * @Fields id : 商品规则参数ID
	 */
	private Long id;

	/**
	 * @Fields itemCatId : 商品类目ID
	 */
	private Long itemCatId;

	/**
	 * @Fields paramData : 参数数据，格式为json格式
	 */
	private String paramData;

	/**
	 * @Fields created : 创建时间
	 */
	private Date created;

	/**
	 * @Fields updated : 更新时间
	 */
	private Date updated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemCatId() {
		return itemCatId;
	}

	public void setItemCatId(Long itemCatId) {
		this.itemCatId = itemCatId;
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

	public String getParamData() {
		return paramData;
	}

	public void setParamData(String paramData) {
		this.paramData = paramData == null ? null : paramData.trim();
	}
}