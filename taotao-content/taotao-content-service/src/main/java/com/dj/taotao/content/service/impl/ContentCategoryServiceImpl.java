package com.dj.taotao.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.taotao.content.service.ContentCategoryService;
import com.dj.taotao.mapper.TbContentCategoryMapper;
import com.dj.taotao.pojo.EasyUITreeNode;
import com.dj.taotao.pojo.TaotaoResult;
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

	@Override
	public TaotaoResult addContentCategory(long parentId, String name) {
		TbContentCategory category = new TbContentCategory();
		category.setParentId(parentId);
		category.setName(name);
		// 1:正常，2：删除
		category.setStatus(1);
		category.setSortOrder(1);
		category.setIsParent(false);
		Date date = new Date();
		category.setCreated(date);
		category.setUpdated(date);
		contentCategoryMapper.insert(category);
		// 判断父节点的状态
		TbContentCategory paraent = contentCategoryMapper.selectByPrimaryKey(parentId);
		if(!paraent.getIsParent()) {
			paraent.setIsParent(true);
			// 更新父节点的状态 
			contentCategoryMapper.updateByPrimaryKey(paraent);
		}
		return TaotaoResult.ok(category);
	}

}
