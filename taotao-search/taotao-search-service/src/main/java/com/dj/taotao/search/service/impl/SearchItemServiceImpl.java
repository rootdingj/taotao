package com.dj.taotao.search.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.taotao.pojo.SearchItem;
import com.dj.taotao.pojo.TaotaoResult;
import com.dj.taotao.search.mapper.SearchItemMapper;
import com.dj.taotao.search.service.SearchItemService;

/**
 * 
 * @ClassName: SearchItemServiceImpl
 * @Description: 商品数据导入索引库
 * @author Steven
 * @date 2019年3月21日
 */
@Service
public class SearchItemServiceImpl implements SearchItemService {

	@Autowired
	private SearchItemMapper searchItemMapper;

	@Autowired
	private SolrServer solrServer;

	@Override
	public TaotaoResult importItemsToIndex() {
		try {
			// 1、查询所有商品数据
			List<SearchItem> itemList = searchItemMapper.getItemList();
			// 2、遍历商品数据并添加到索引库中
			for (SearchItem item : itemList) {
				// 创建文档对象
				SolrInputDocument document = new SolrInputDocument();
				// 向文档中添加域
				document.addField("id", item.getId());
				document.addField("item_title", item.getTitle());
				document.addField("item_sell_point", item.getSell_point());
				document.addField("item_price", item.getPrice());
				document.addField("item_image", item.getImage());
				document.addField("item_category_name", item.getCategory_name());
				document.addField("item_desc", item.getItem_desc());
				// 把文档写入索引库
				solrServer.add(document);
			}
			// 3、提交
			solrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, "数据导入失败");
		}
		// 4、返回添加成功
		return TaotaoResult.ok();
	}

}
