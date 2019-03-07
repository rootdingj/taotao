package com.dj.taotao.content.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.taotao.content.service.ContentCategoryService;
import com.dj.taotao.mapper.TbContentCategoryMapper;
import com.dj.taotao.pojo.EasyUITreeNode;
import com.dj.taotao.pojo.TbContentCategory;
import com.dj.taotao.pojo.TbContentCategoryExample;
import com.dj.taotao.pojo.TbContentCategoryExample.Criteria;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;

	@Override
	public List<EasyUITreeNode> getContentCategoryList(long parentId) {
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		ArrayList<EasyUITreeNode> resultList = new ArrayList<>();
		for (TbContentCategory content : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(content.getId());
			node.setText(content.getName());
			node.setStatus(content.getIsParent() ? "closed" : "open");
			resultList.add(node);
		}
		return resultList;
	}

}
