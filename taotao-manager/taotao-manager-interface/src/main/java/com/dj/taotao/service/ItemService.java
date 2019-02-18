package com.dj.taotao.service;

import com.dj.taotao.pojo.EasyUIResult;
import com.dj.taotao.pojo.TbItem;

public interface ItemService {
	
	TbItem getItemById(long itemId);
	EasyUIResult getItemList(int page,int rows);

}
