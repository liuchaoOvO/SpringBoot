package com.lc;

import com.lc.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: CoderTnT
 * @date: 2018/12/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest
{

    @Autowired
    private RedisService  stringRedisService;

    @Test
    public void set() {
        stringRedisService.set("namelll","张三llcl");
    }

    @Test
    public void get(){
        System.out.println(stringRedisService.get("namelll"));
    }
}
