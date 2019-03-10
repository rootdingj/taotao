package com.dj.taotao.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.taotao.content.service.ContentService;
import com.dj.taotao.mapper.TbContentMapper;
import com.dj.taotao.pojo.TaotaoResult;
import com.dj.taotao.pojo.TbContent;
import com.dj.taotao.pojo.TbContentExample;
import com.dj.taotao.pojo.TbContentExample.Criteria;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;

	@Override
	public TaotaoResult addContent(TbContent content) {
		Date date = new Date();
		content.setCreated(date);
		content.setUpdated(date);
		contentMapper.insert(content);
		return TaotaoResult.ok();
	}

	@Override
	public List<TbContent> getContentByCid(long cid) {
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(cid);
		return contentMapper.selectByExample(example);
	}

}
