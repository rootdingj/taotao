package com.dj.taotao.content.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dj.taotao.content.service.ContentService;
import com.dj.taotao.jedis.JedisClient;
import com.dj.taotao.mapper.TbContentMapper;
import com.dj.taotao.pojo.TaotaoResult;
import com.dj.taotao.pojo.TbContent;
import com.dj.taotao.pojo.TbContentExample;
import com.dj.taotao.pojo.TbContentExample.Criteria;
import com.dj.taotao.utils.JsonUtils;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${INDEX_CONTENT}")
	private String indexContent;

	@Override
	public TaotaoResult addContent(TbContent content) {
		Date date = new Date();
		content.setCreated(date);
		content.setUpdated(date);
		contentMapper.insert(content);
		// 同步缓存，删除key对应的缓存信息
		jedisClient.hdel(indexContent, content.getCategoryId().toString());
		return TaotaoResult.ok();
	}

	@Override
	public List<TbContent> getContentByCid(long cid) {
		// 先查询缓存
		try {
			// 查询缓存，并把查询结果转成list返回
			String json = jedisClient.hget(indexContent, cid + "");
			if (StringUtils.isNotBlank(json)) {
				List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		List<TbContent> list = contentMapper.selectByExample(example);
		// 如果缓存中不存在，先查询数据库，再把结果存入缓存
		try {
			jedisClient.hset(indexContent, cid + "", JsonUtils.objectToJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
