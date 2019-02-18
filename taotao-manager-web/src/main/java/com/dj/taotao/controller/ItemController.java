package com.dj.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dj.taotao.pojo.EasyUIResult;
import com.dj.taotao.pojo.TbItem;
import com.dj.taotao.service.ItemService;

/**
 * 商品管理Controller
 * 
 * @author dj673
 *
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {

		TbItem item = itemService.getItemById(itemId);
		return item;
	}

	@RequestMapping("item/list")
	@ResponseBody
	public EasyUIResult getItemList(Integer page, Integer rows) {
		
		return itemService.getItemList(page, rows);
	}

}
