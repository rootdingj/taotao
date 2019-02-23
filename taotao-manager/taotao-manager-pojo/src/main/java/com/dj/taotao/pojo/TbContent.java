package com.dj.taotao.pojo;

import java.io.Serializable;
import java.util.Date;

/** 
* @ClassName: TbContent 
* @Description: 内容 
* @author Steven 
* @date 2019年2月23日  
*/
public class TbContent implements Serializable {

	private static final long serialVersionUID = -7373913197004075806L;

	private Long id;

	/**
	 * @Fields categoryId : 内容类目ID
	 */
	private Long categoryId;

	/**
	 * @Fields title : 内容标题
	 */
	private String title;

	/**
	 * @Fields subTitle : 子标题
	 */
	private String subTitle;

	/**
	 * @Fields titleDesc : 标题描述
	 */
	private String titleDesc;

	/**
	 * @Fields url : 链接
	 */
	private String url;

	/**
	 * @Fields pic : 图片绝对路径
	 */
	private String pic;

	/**
	 * @Fields pic2 : 图片2
	 */
	private String pic2;

	/**
	 * @Fields content : 内容
	 */
	private String content;

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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getTitleDesc() {
		return titleDesc;
	}

	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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