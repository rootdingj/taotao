package com.dj.taotao.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.dj.taotao.jedis.JedisClient;
import com.dj.taotao.mapper.TbItemDescMapper;
import com.dj.taotao.mapper.TbItemMapper;
import com.dj.taotao.pojo.EasyUIResult;
import com.dj.taotao.pojo.TaotaoResult;
import com.dj.taotao.pojo.TbItem;
import com.dj.taotao.pojo.TbItemDesc;
import com.dj.taotao.pojo.TbItemExample;
import com.dj.taotao.service.ItemService;
import com.dj.taotao.utils.IDUtils;
import com.dj.taotao.utils.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: ItemServiceImpl
 * @Description: 商品管理Service
 * @author Steven
 * @date 2019年2月27日
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Resource(name = "itemAddtopic")
	private Destination destination;
	@Autowired
	private JedisClient jedisClient;
	@Value("${ITEM_INFO}")
	private String ITEM_INFO;
	@Value("${TIEM_EXPIRE}")
	private Integer TIEM_EXPIRE;

	@Override
	public TbItem getItemById(long itemId) {
		// 查询数据库之前先查询缓存
		TbItem tbItem = null;
		String baseKey = ITEM_INFO + ":" + itemId + ":BASE";
		try {
			String json = jedisClient.get(baseKey);
			if (StringUtils.isNotBlank(json)) {
				// 把json数据转换成pojo
				tbItem = JsonUtils.jsonToPojo(json, TbItem.class);
				return tbItem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 缓存中没有查询数据库
		tbItem = itemMapper.selectByPrimaryKey(itemId);
		try {
			// 把查询结果添加到缓存
			jedisClient.set(baseKey, JsonUtils.objectToJson(tbItem));
			// 设置过期时间，提高缓存的利用率
			jedisClient.expire(baseKey, TIEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tbItem;
	}

	@Override
	public EasyUIResult getItemList(int page, int rows) {
		// 设置分页信息
		PageHelper.startPage(page, rows);
		// 执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		// 取查询结果
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		EasyUIResult result = new EasyUIResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TaotaoResult addItem(TbItem item, String desc) {
		Date date = new Date();
		// 生成商品ID
		final long itemId = IDUtils.genItemId();
		// 补全item属性
		item.setId(itemId);
		// 商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		item.setCreated(date);
		item.setUpdated(date);
		// 向商品表插入数据
		itemMapper.insert(item);
		// 创建一个商品描述的pojo
		TbItemDesc itemDesc = new TbItemDesc();
		// 向商品描述表插入数据
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		itemDescMapper.insert(itemDesc);
		// 想activemq发送商品添加消息
		jmsTemplate.send(destination, new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				// 发送商品的ID
				return session.createTextMessage(itemId + "");
			}
		});
		return TaotaoResult.ok();
	}

	@Override
	public TbItemDesc getItemDescById(long itemId) {
		// 查询数据库之前先查询缓存
		TbItemDesc itemDesc = null;
		String descKey = ITEM_INFO + ":" + itemId + ":DESC";
		try {
			String json = jedisClient.get(descKey);
			if (StringUtils.isNotBlank(json)) {
				// 把json数据转换成pojo
				itemDesc = JsonUtils.jsonToPojo(json, TbItemDesc.class);
				return itemDesc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 缓存中没有查询数据库
		itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
		try {
			// 把查询结果添加到缓存
			jedisClient.set(descKey, JsonUtils.objectToJson(itemDesc));
			// 设置过期时间，提高缓存的利用率
			jedisClient.expire(descKey, TIEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemDesc;
	}

}
