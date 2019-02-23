package com.dj.taotao.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TbItemParamItem
 * @Description: 商品规格和商品的关系
 * @author Steven
 * @date 2019年2月23日
 */
public class TbItemParamItem implements Serializable {

	private static final long serialVersionUID = -295157229710842574L;

	private Long id;

	/**
	 * @Fields itemId : 商品ID
	 */
	private Long itemId;

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

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
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