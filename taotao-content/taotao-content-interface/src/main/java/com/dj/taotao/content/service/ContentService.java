package com.dj.taotao.content.service;

import java.util.List;

import com.dj.taotao.pojo.TaotaoResult;
import com.dj.taotao.pojo.TbContent;

public interface ContentService {

	TaotaoResult addContent(TbContent content);
	
	List<TbContent> getContentByCid(long cid);

}
