package com.dj.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.taotao.mapper.TbItemMapper;
import com.dj.taotao.pojo.EasyUIResult;
import com.dj.taotao.pojo.TbItem;
import com.dj.taotao.pojo.TbItemExample;
import com.dj.taotao.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/** 
* @ClassName: ItemServiceImpl 
* @Description: 商品管理Service
* @author Steven 
* @date 2019年2月27日  
*/
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TbItem getItemById(long itemId) {
		
		return itemMapper.selectByPrimaryKey(itemId);
	}

	@Override
	public EasyUIResult getItemList(int page, int rows) {
		// 设置分页信息
		PageHelper.startPage(page, rows);
		// 执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		// 取查询结果
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		EasyUIResult result = new EasyUIResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
