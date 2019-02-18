package com.dj.taotao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dj.taotao.mapper.TbItemMapper;
import com.dj.taotao.pojo.TbItem;
import com.dj.taotao.pojo.TbItemExample;
import com.dj.taotao.pojo.TbItemExample.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TestPageHelper {
	
	@SuppressWarnings("resource")
	@Test
	public void testPageHelper() throws Exception{
		
		// 1.mybatis配置文件中配置分页插件
		// 2.执行查询之前设置分页条件
		PageHelper.startPage(1, 10);
		// 3.执行查询
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
		TbItemExample tbItemExample = new TbItemExample();
//		Criteria criteria = tbItemExample.createCriteria();
		List<TbItem> list = itemMapper.selectByExample(tbItemExample);
		// 4.取分页信息
		PageInfo<TbItem> info = new PageInfo<>(list);
		System.out.println("总记录数："+info.getTotal());
		System.out.println("总页数"+info.getPages());
		
	}
	
	
	

}
