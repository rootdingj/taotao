package com.dj.taotao.search.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.dj.taotao.pojo.SearchItem;
import com.dj.taotao.pojo.SearchResult;

/**
 * 
 * @ClassName: SearchDao
 * @Description: 商品搜索DAO
 * @author Steven
 * @date 2019年3月23日
 */
@Repository
public class SearchDao {

	@Autowired
	private SolrServer solrServer;

	public SearchResult search(SolrQuery query) {
		SearchResult result = new SearchResult();
		try {
			// 根据SolrQuery对象进行查询
			QueryResponse response = solrServer.query(query);
			// 取查询结果
			SolrDocumentList resultList = response.getResults();
			// 取总记录数
			long numFound = resultList.getNumFound();
			result.setRecordCount(numFound);
			List<SearchItem> itemList = new ArrayList<>();
			for (SolrDocument solrDocument : resultList) {
				SearchItem item = new SearchItem();
				item.setId((String) solrDocument.get("id"));
				item.setCategory_name((String) solrDocument.get("item_category_name"));
				item.setImage((String) solrDocument.get("item_image"));
				item.setPrice((long) solrDocument.get("item_price"));
				item.setSell_point((String) solrDocument.get("item_sell_point"));
				// 取高亮显示
				Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
				List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
				String itemTitle = "";
				if (CollectionUtils.isEmpty(list)) {
					itemTitle = (String) solrDocument.get("item_title");
				} else {
					itemTitle = list.get(0);
				}
				item.setTitle(itemTitle);
				// 添加到商品列表
				itemList.add(item);
			}
			// 把结果添加到SearchResult中
			result.setItemList(itemList);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		return result;
	}

}
