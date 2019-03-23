package com.dj.taotao.search.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.taotao.pojo.SearchResult;
import com.dj.taotao.search.dao.SearchDao;
import com.dj.taotao.search.service.SearchService;

/**
 * 
 * @ClassName: SearchServiceImpl
 * @Description: 商品搜索Service
 * @author Steven
 * @date 2019年3月23日
 */
@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;

	@Override
	public SearchResult search(String queryStr, int page, int rows) {
		// 创建一个solrQuery对象
		SolrQuery query = new SolrQuery();
		// 设置查询条件
		query.setQuery(queryStr);
		// 设置分页条件
		if (page < 1) {
			page = 1;
		}
		query.setStart((page - 1) * rows);
		if (rows < 1) {
			rows = 10;
		}
		query.setRows(rows);
		// 设置默认搜索域
		query.set("df", "item_title");
		// 设置高亮
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<font color='red'>");
		query.setHighlightSimplePost("</font>");
		SearchResult result = null;
		try {
			result = searchDao.search(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long recordCount = result.getRecordCount();
		long pages = recordCount / rows;
		if (recordCount % rows > 0) {
			pages++;
		}
		result.setTotalPages(pages);
		return result;
	}

}
