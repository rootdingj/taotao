package com.dj.taotao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dj.taotao.pojo.SearchResult;
import com.dj.taotao.search.service.SearchService;

/**
 * 
 * @ClassName: SearchController
 * @Description: 搜索服务Controller
 * @author Steven
 * @date 2019年3月23日
 */
@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;

	@Value("${SEARCH_RESULT_ROWS}")
	private int rows;

	@RequestMapping("/search")
	public String search(@RequestParam("q") String queryStr, @RequestParam(defaultValue = "1") Integer page,
			Model model) {
//		int i = 1/0;
		try {
			queryStr = new String(queryStr.getBytes("iso8859-1"), "utf-8");
			SearchResult result = searchService.search(queryStr, page, rows);
			model.addAttribute("query", queryStr);
			model.addAttribute("totalPages", result.getTotalPages());
			model.addAttribute("itemList", result.getItemList());
			model.addAttribute("page", page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "search";
	}

}
