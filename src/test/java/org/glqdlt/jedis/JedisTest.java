package org.glqdlt.jedis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {

	@Test
	public void connectionTest() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		JedisPool pool = new JedisPool(jedisPoolConfig, "ash725.iptime.org", 16379, 1000, "P@ssw0rdsmsrlfrp");
		// config, host주소, 포트, 타임아웃, 패스워드
		Jedis jedis = pool.getResource();

		// jedis.set("foo", "bar");
		String val = jedis.get("foo");

		System.out.println(val);

	}

}
