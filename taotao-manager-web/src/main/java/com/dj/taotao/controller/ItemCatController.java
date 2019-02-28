package com.dj.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dj.taotao.pojo.EasyUITreeNode;
import com.dj.taotao.service.ItemCatService;

/**
 * @ClassName: ItemCatController
 * @Description: 商品分类管理Controller
 * @author Steven
 * @date 2019年2月28日
 */
@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {

		return itemCatService.getItemCatList(parentId);
	}

}
