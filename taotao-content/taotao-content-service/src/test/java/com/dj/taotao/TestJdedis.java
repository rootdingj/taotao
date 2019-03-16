package com.dj.taotao;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestJdedis {

	@Test
	public void testJedis() {
		Jedis jedis = new Jedis("47.106.125.36", 6379);
		jedis.set("jedis-key", "123");
		System.out.println(jedis.get("jedis-key"));
		jedis.close();
	}

	@Test
	public void testJedisPool() {
		// 创建一个Jedis连接池对象（单例）
		JedisPool pool = new JedisPool("47.106.125.36", 6379);
		// 从连接池中获取连接
		Jedis jedis = pool.getResource();
		// 使用jedis操作数据库（方法级别）
		System.out.println(jedis.get("jedis-key"));
		// 关闭jedis连接
		jedis.close();
		// 系统关闭前关闭连接池
		pool.close();

	}

}
