package com.dj.taotao.search.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import com.dj.taotao.pojo.SearchItem;
import com.dj.taotao.search.mapper.SearchItemMapper;
/**
 * 
 * @ClassName: ItemAddMessageListener 
 * @Description: 商品添加消息监听器 
 * @author Steven 
 * @date 2019年3月29日
 */
public class ItemAddMessageListener implements MessageListener {

	@Autowired
	private SearchItemMapper searchItemMapper;
	@Autowired
	private SolrServer solrServer;

	@Override
	public void onMessage(Message message) {
		try {
			// 1.从消息中取出商品Id
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			long itemId = Long.parseLong(text);
			// 等待事物提交
			Thread.sleep(1000L);
			// 2.根据商品Id取数据库中商品信息
			SearchItem item = searchItemMapper.getItemById(itemId);
			// 3.创建文档对象
			SolrInputDocument document = new SolrInputDocument();
			// 4.向文档中添加域
			document.addField("id", item.getId());
			document.addField("item_title", item.getTitle());
			document.addField("item_sell_point", item.getSell_point());
			document.addField("item_price", item.getPrice());
			document.addField("item_image", item.getImage());
			document.addField("item_category_name", item.getCategory_name());
			document.addField("item_desc", item.getItem_desc());
			// 5.把文档对象写入索引库
			solrServer.add(document);
			// 6.提交
			solrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
