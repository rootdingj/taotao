package com.dj.taotao.pojo;

import java.io.Serializable;

/**
 * @ClassName: EasyUITreeNode
 * @Description: 树节点pojo
 * @author Steven
 * @date 2019年2月28日
 */
public class EasyUITreeNode implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = -3150485383210344356L;
	/** 节点ID */
	private long id;
	/** 节点描述 */
	private String text;
	/** 节点状态,是否有子节点 */
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
