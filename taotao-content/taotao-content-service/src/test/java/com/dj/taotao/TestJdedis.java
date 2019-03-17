package com.dj.taotao;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dj.taotao.jedis.JedisClient;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
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

	@Test
	public void testJedisCluster() {
		// 创建一个JedisCluster对象，构造参数set类型，集合中每个元素是PostAndPort类型
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("47.106.125.36", 7001));
		nodes.add(new HostAndPort("47.106.125.36", 7002));
		nodes.add(new HostAndPort("47.106.125.36", 7003));
		nodes.add(new HostAndPort("47.106.125.36", 7004));
		nodes.add(new HostAndPort("47.106.125.36", 7005));
		nodes.add(new HostAndPort("47.106.125.36", 7006));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		// 直接使用jedisCluster对象操作redis，自带连接池，jedisCluster对象可以是单例的
		jedisCluster.set("JedisCluster", "123456");
		System.out.println(jedisCluster.get("JedisCluster"));
		jedisCluster.close();

	}
	
	@Test
	public void testJedisClient() {
		// 初始化Spring容器
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("classpath:spring/applicationContext-jedis.xml");
		// 获取jedisClient对象
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		//使用JedisClient对象操作redis
		jedisClient.set("jedisclient", "mytest");
		System.out.println("获取数据： "+jedisClient.get("jedisclient"));
		
	}

}
