package com.dj.taotao.search.dao;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

		return result;
	}

}
