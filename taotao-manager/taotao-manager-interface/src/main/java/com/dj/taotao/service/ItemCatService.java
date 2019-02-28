package com.dj.taotao.service;

import java.util.List;

import com.dj.taotao.pojo.EasyUITreeNode;

/**
 * @ClassName: ItemCatService
 * @Description: 商品分类接口
 * @author Steven
 * @date 2019年2月28日
 */
public interface ItemCatService {

	/**
	 * @Title: getItemCatList
	 * @Description: 获取商品分类列表
	 * @param parentId
	 * @return 返回类型
	 */
	List<EasyUITreeNode> getItemCatList(long parentId);

}
