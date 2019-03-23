package com.dj.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dj.taotao.pojo.TaotaoResult;
import com.dj.taotao.search.service.SearchItemService;

/**
 * 
 * @ClassName: IndexManagerController
 * @Description: 索引库管理Controller
 * @author Steven
 * @date 2019年3月23日
 */
@Controller
public class IndexManagerController {

	@Autowired
	private SearchItemService searchItemService;

	@RequestMapping("/index/import")
	@ResponseBody
	public TaotaoResult importIndex() {
		
		return searchItemService.importItemsToIndex();
	}

}
