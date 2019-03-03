package com.dj.taotao.service;

import com.dj.taotao.pojo.EasyUIResult;
import com.dj.taotao.pojo.TaotaoResult;
import com.dj.taotao.pojo.TbItem;

public interface ItemService {
	
	/** 
	* @Title: getItemById 
	* @Description: 根据商品ID查询商品信息
	* @param itemId
	* @return TbItem  返回类型  
	*/
	TbItem getItemById(long itemId);
	/** 
	* @Title: getItemList 
	* @Description: 获取商品信息列表
	* @param page
	* @param rows
	* @return EasyUIResult  返回类型  
	*/
	EasyUIResult getItemList(int page,int rows);
	
	/** 
	* @Title: addItem 
	* @Description: 添加商品信息
	* @param item
	* @param desc
	* @return EasyUIResult  返回类型  
	*/
	TaotaoResult addItem(TbItem item,String desc);

}
