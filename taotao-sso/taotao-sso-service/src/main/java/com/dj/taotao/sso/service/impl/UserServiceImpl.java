package com.dj.taotao.sso.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.dj.taotao.jedis.JedisClient;
import com.dj.taotao.mapper.TbUserMapper;
import com.dj.taotao.pojo.TaotaoResult;
import com.dj.taotao.pojo.TbUser;
import com.dj.taotao.pojo.TbUserExample;
import com.dj.taotao.pojo.TbUserExample.Criteria;
import com.dj.taotao.sso.service.UserService;
import com.dj.taotao.utils.JsonUtils;

/**
 * 
 * @ClassName: UserServiceImpl
 * @Description: 用户管理service
 * @author Steven
 * @date 2019年4月7日
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private TbUserMapper userMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${USER_SESSION}")
	private String USER_SESSION;
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;

	@Override
	public TaotaoResult checkData(String param, int type) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		// 添加查询条件
		// type:1，判断用户名是否可用
		if (type == 1) {
			criteria.andUsernameEqualTo(param);
		}
		// type:2，判断手机号是否可用
		else if (type == 2) {
			criteria.andPhoneEqualTo(param);
		}
		// type:3，判断邮箱是否可用
		else if (type == 3) {
			criteria.andEmailEqualTo(param);
		} else {
			return TaotaoResult.build(400, "请求参数包含非法数据！");
		}
		List<TbUser> list = userMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return TaotaoResult.ok(true);
		} else {
			return TaotaoResult.ok(false);
		}
	}

	@Override
	public TaotaoResult register(TbUser user) {
		if (StringUtils.isEmpty(user.getUsername())) {
			return TaotaoResult.build(400, "用户名不能为空！");
		} else {
			TaotaoResult checkData = checkData(user.getUsername(), 1);
			if (!(boolean) checkData.getData()) {
				return TaotaoResult.build(400, "用户名重复！");
			}
		}
		if (StringUtils.isEmpty(user.getPassword())) {
			return TaotaoResult.build(400, "密码不能为空！");
		}
		if (StringUtils.isNotEmpty(user.getPhone())) {
			TaotaoResult checkData = checkData(user.getPhone(), 2);
			if (!(boolean) checkData.getData()) {
				return TaotaoResult.build(400, "手机号重复！");
			}
		}
		if (StringUtils.isNotEmpty(user.getEmail())) {
			TaotaoResult checkData = checkData(user.getEmail(), 3);
			if (!(boolean) checkData.getData()) {
				return TaotaoResult.build(400, "邮箱重复重复！");
			}
		}
		user.setCreated(new Date());
		user.setUpdated(new Date());
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		return TaotaoResult.ok("注册成！");
	}

	@Override
	public TaotaoResult login(String username, String password) {
		// 判断用户名、密码是否正确
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbUser> list = userMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return TaotaoResult.build(400, "用户名或密码不正确");
		}
		TbUser user = list.get(0);
		user.setPassword(null);
		// 使用UUID生成token
		String token = UUID.randomUUID().toString();
		// 把用户信息保存到redis中，key就是token，value为用户信息
		jedisClient.set(USER_SESSION + ":" + token, JsonUtils.objectToJson(user));
		// 设置key的过期时间
		jedisClient.expire(USER_SESSION + ":" + token, SESSION_EXPIRE);
		// 返回登录成功，并把token返回
		return TaotaoResult.ok(token);
	}

}
