package com.dj.taotao.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TbItemDesc
 * @Description: 商品描述
 * @author Steven
 * @date 2019年2月23日
 */
public class TbItemDesc implements Serializable {

	private static final long serialVersionUID = 5166990358720976272L;

	/**
	 * @Fields itemId : 商品ID
	 */
	private Long itemId;

	/**
	 * @Fields itemDesc : 商品描述
	 */
	private String itemDesc;

	/**
	 * @Fields created : 创建时间
	 */
	private Date created;

	/**
	 * @Fields updated : 更新时间
	 */
	private Date updated;

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

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc == null ? null : itemDesc.trim();
	}
}