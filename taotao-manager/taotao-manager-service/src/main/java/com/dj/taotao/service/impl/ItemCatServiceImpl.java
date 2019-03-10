package com.dj.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.taotao.mapper.TbItemCatMapper;
import com.dj.taotao.pojo.EasyUITreeNode;
import com.dj.taotao.pojo.TbItemCat;
import com.dj.taotao.pojo.TbItemCatExample;
import com.dj.taotao.pojo.TbItemCatExample.Criteria;
import com.dj.taotao.service.ItemCatService;

/** 
* @ClassName: ItemCatServiceImpl 
* @Description: 商品分类管理Service
* @author Steven 
* @date 2019年2月28日  
*/
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		TbItemCatExample itemCat = new TbItemCatExample();
		Criteria criteria = itemCat.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(itemCat);
		ArrayList<EasyUITreeNode> resultList = new ArrayList<>(16);
		for (TbItemCat tbItemCat : list) {
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
//			node.setStatus(tbItemCat.getIsParent() ? "closed" : "open");
			node.setStatus(tbItemCat.getIsParent() ? "open" : "closed");
			resultList.add(node);
		}
		return resultList;
	}

}
