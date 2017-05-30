package org.glqdlt.jedis;

import org.glqdlt.home.servers.domain.user.UserVO;
import org.junit.Test;

import com.google.gson.Gson;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {

	@Test
	public void connectionTest() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		JedisPool pool = new JedisPool(jedisPoolConfig, "url", 16379, 1000, "password");
		// config, host주소, 포트, 타임아웃, 패스워드
		Jedis jedis = pool.getResource();
		UserVO uvo = new UserVO();
		uvo.setUserId("testid");
		uvo.setUserPw("testpw");
		uvo.setUserEmail("test@test");
		uvo.setUserAuth(9);
		
		Gson gson = new Gson();
		String uvoStr = gson.toJson(uvo);
//		jedis.set("session1", uvoStr);
		
//		 jedis.set("foo", "bar1");
//		 jedis.del("foo");
		String val = jedis.get("session1");

		System.out.println(val);

	}

}
