package com.dj.taotao.jedis;

/**
 * @ClassName: JedisClient
 * @Description: jedis客户端接口</br>
 *               使用策略模式定义jedis客户端的单机版和集群版的方法
 * @date 2019年3月17日
 */
public interface JedisClient {

	String set(String key, String value);

	String get(String key);

	Boolean exists(String key);

	Long expire(String key, int seconds);

	Long ttl(String key);

	Long incr(String key);

	Long hset(String key, String field, String value);

	String hget(String key, String field);

	Long hdel(String key, String... field);
}
