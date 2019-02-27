package com.dj.taotao.service;

import com.dj.taotao.pojo.EasyUIResult;
import com.dj.taotao.pojo.TbItem;

public interface ItemService {
	
	/** 
	* @Title: getItemById 
	* @Description: 根据商品ID查询商品信息
	* @param @param itemId
	* @param @return  设定文件  
	* @return TbItem  返回类型  
	* @throws 
	*/
	TbItem getItemById(long itemId);
	/** 
	* @Title: getItemList 
	* @Description: 获取商品信息列表
	* @param @param page
	* @param @param rows
	* @param @return  设定文件  
	* @return EasyUIResult  返回类型  
	* @throws 
	*/
	EasyUIResult getItemList(int page,int rows);

}
