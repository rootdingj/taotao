package com.dj.solrj;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TestSolrJ {

	@Test
	public void testAddDocument() throws Exception {
		// 创建一个SolrServer对象（httpSolrServer），需指定solr服务的URL
		SolrServer solrServer = new HttpSolrServer("http://47.106.125.36:8080/solr/");
		// 创建一个文档对象solrInputDocument
		SolrInputDocument document = new SolrInputDocument();
		// 向文档添加域，必须有id，域的名称必须在schema.xml中定义
		document.addField("id", "testsolr1");
		document.addField("item_title", "商品测试1");
		document.addField("item_price", 100);
		// 把文档对象写入索引库
		solrServer.add(document);
		// 提交
		solrServer.commit();

	}

	@Test
	public void testDelDocumentById() throws Exception {
		// 创建一个SolrServer对象（httpSolrServer），需指定solr服务的URL
		SolrServer solrServer = new HttpSolrServer("http://47.106.125.36:8080/solr/");
		solrServer.deleteById("testsolr1");
		// 提交
		solrServer.commit();
	}

	@Test
	public void testDelDocumentByQuery() throws Exception {
		// 创建一个SolrServer对象（httpSolrServer），需指定solr服务的URL
		SolrServer solrServer = new HttpSolrServer("http://47.106.125.36:8080/solr/");
		// 全部删除
//		solrServer.deleteByQuery("*:*");
		solrServer.deleteByQuery("id:testsolr1");
		// 提交
		solrServer.commit();
	}

}
