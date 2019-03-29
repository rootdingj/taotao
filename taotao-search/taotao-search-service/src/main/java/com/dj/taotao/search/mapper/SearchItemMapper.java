package com.dj.taotao.search.mapper;

import java.util.List;

import com.dj.taotao.pojo.SearchItem;

public interface SearchItemMapper {

	List<SearchItem> getItemList();
	SearchItem getItemById(long itemId);

}
