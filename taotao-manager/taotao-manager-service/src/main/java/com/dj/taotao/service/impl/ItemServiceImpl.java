package com.dj.taotao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.taotao.mapper.TbItemMapper;
import com.dj.taotao.pojo.TbItem;
import com.dj.taotao.service.ItemService;

/**
 * 商品管理Service
 * 
 * @author steven
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TbItem getItemById(long itemId) {
		
		return itemMapper.selectByPrimaryKey(itemId);
	}

}
