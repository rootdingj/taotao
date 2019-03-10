package com.dj.taotao.protal.pojo;

/**
 * @ClassName: AD1Node
 * @Description: 大广告位pojo
 * @author Steven
 * @date 2019年3月10日
 */
public class AD1Node {

	/** 图片 */
	private String srcB;
	/** 图片高 */
	private Integer height;
	/** 图片提示 */
	private String alt;
	/** 图片宽 */
	private Integer width;
	/** 图片2(图片宽屏窄屏) */
	private String src;
	/** 图片2宽 */
	private Integer widthB;
	/** 图片链接 */
	private String href;
	/** 图片2高 */
	private Integer heightB;

	public String getSrcB() {
		return srcB;
	}

	public void setSrcB(String srcB) {
		this.srcB = srcB;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public Integer getWidthB() {
		return widthB;
	}

	public void setWidthB(Integer widthB) {
		this.widthB = widthB;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Integer getHeightB() {
		return heightB;
	}

	public void setHeightB(Integer heightB) {
		this.heightB = heightB;
	}

}
