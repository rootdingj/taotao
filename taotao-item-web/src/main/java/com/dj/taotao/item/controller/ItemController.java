package com.dj.taotao.item.controller;
/**
 * 
 * @ClassName: ItemController 
 * @Description: 商品详情展示controller
 * @author Steven 
 * @date 2019年3月30日
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dj.taotao.item.pojo.Item;
import com.dj.taotao.pojo.TbItem;
import com.dj.taotao.pojo.TbItemDesc;
import com.dj.taotao.service.ItemService;

public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/itemId")
	public String showItem(@PathVariable Long itemId, Model model) {
		// 获取商品信息
		TbItem tbItem = itemService.getItemById(itemId);
		Item item = new Item(tbItem);
		// 获取商品详情信息
		TbItemDesc itemDesc = itemService.getItemDescById(itemId);
		model.addAttribute("item", item);
		model.addAttribute("itemDesc", itemDesc);
		return "item";
	}

}
