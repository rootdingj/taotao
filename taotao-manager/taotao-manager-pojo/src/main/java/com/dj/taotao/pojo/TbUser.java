package com.dj.taotao.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TbUser
 * @Description: 用户
 * @author Steven
 * @date 2019年2月23日
 */
public class TbUser implements Serializable {

	private static final long serialVersionUID = -8862973523246843183L;

	/**
	 * @Fields id : 用户ID
	 */
	private Long id;

	/**
	 * @Fields username : 用户名
	 */
	private String username;

	/**
	 * @Fields password : 密码，加密存储
	 */
	private String password;

	/**
	 * @Fields phone : 注册手机号
	 */
	private String phone;

	/**
	 * @Fields email : 注册邮箱
	 */
	private String email;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
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