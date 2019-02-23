package com.dj.taotao.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TbItemCat
 * @Description: 商品类目
 * @author Steven
 * @date 2019年2月23日
 */
public class TbItemCat implements Serializable {

	private static final long serialVersionUID = -7507086778694871959L;

	/**
	 * @Fields id : 类目ID
	 */
	private Long id;

	/**
	 * @Fields parentId : 父类目(ID为0时，表一级类目)
	 */
	private Long parentId;

	/**
	 * @Fields name : 类目名称
	 */
	private String name;

	/**
	 * @Fields status : 状态(1:正常,2:删除)
	 */
	private Integer status;

	/**
	 * @Fields sortOrder : 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
	 */
	private Integer sortOrder;

	/**
	 * @Fields isParent : 该类目是否为父类目(1:true，0:false)
	 */
	private Boolean isParent;

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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
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