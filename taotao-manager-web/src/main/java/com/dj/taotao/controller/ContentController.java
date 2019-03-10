package com.dj.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dj.taotao.content.service.ContentService;
import com.dj.taotao.pojo.TaotaoResult;
import com.dj.taotao.pojo.TbContent;

/**
 * 
 * @ClassName: ContentController
 * @Description: 内容管理Controller
 * @author Steven
 * @date 2019年3月10日
 */
public class ContentController {

	@Autowired
	private ContentService contentService;

	@RequestMapping("/content/save")
	@ResponseBody
	public TaotaoResult addContent(TbContent content) {

		return contentService.addContent(content);
	}

}
