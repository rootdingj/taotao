package com.dj.taotao.pojo;

import java.io.Serializable;
import java.util.List;

public class EasyUIResult implements Serializable {

	private static final long serialVersionUID = -8217476764679564871L;
	private long total;
	private List<?> rows;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
