package com.dj.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.taotao.mapper.TbItemDescMapper;
import com.dj.taotao.mapper.TbItemMapper;
import com.dj.taotao.pojo.EasyUIResult;
import com.dj.taotao.pojo.TaotaoResult;
import com.dj.taotao.pojo.TbItem;
import com.dj.taotao.pojo.TbItemDesc;
import com.dj.taotao.pojo.TbItemExample;
import com.dj.taotao.service.ItemService;
import com.dj.taotao.utils.IDUtils;
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

	@Override
	public TbItem getItemById(long itemId) {

		return itemMapper.selectByPrimaryKey(itemId);
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
		long itemId = IDUtils.genItemId();
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
		return TaotaoResult.ok();
	}

}
