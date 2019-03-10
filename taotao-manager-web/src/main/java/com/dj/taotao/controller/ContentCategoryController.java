package com.dj.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dj.taotao.content.service.ContentCategoryService;
import com.dj.taotao.pojo.EasyUITreeNode;
import com.dj.taotao.pojo.TaotaoResult;

/**
 * 
 * @ClassName: ContentCategoryController
 * @Description: 内容分类管理Controller
 * @author Steven
 * @date 2019年3月7日
 */
@Controller
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;

	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {

		return contentCategoryService.getContentCategoryList(parentId);

	}

	@RequestMapping("/content/category/create")
	@ResponseBody
	public TaotaoResult addContentCategory(Long parentId, String name) {
		return contentCategoryService.addContentCategory(parentId, name);
	}

}
