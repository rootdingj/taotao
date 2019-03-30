package com.dj.taotao.item.pojo;

import org.apache.commons.lang3.StringUtils;

import com.dj.taotao.pojo.TbItem;

@SuppressWarnings("serial")
public class Item extends TbItem {

	public Item(TbItem tbItem) {
		this.setTitle(tbItem.getTitle());
		this.setSellPoint(tbItem.getSellPoint());
		this.setPrice(tbItem.getPrice());
		this.setNum(tbItem.getNum());
		this.setBarcode(tbItem.getBarcode());
		this.setImage(tbItem.getImage());
		this.setCid(tbItem.getCid());
		this.setStatus(tbItem.getStatus());
		this.setCreated(tbItem.getCreated());
		this.setUpdated(tbItem.getUpdated());
	}

	public String[] getImages() {
		String images = this.getImage();
		if (StringUtils.isNotEmpty(images)) {
			return images.split(",");
		}
		return null;
	}

}
