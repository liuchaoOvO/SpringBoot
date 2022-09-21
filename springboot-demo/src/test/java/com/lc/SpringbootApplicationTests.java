package com.lc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {
	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Test
	public void contextLoads() {

		stringRedisTemplate.opsForValue().set("testconnect","hello world");
		//设置值stringRedisTemplate.opsForValue().get("testconnect");//取值
	}

}
