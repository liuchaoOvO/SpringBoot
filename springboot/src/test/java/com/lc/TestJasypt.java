package com.lc;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by liuchao on 2018/8/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestJasypt{
        @Autowired
        StringEncryptor encryptor;

        @Test
        public void getPass() {
            String url = encryptor.encrypt("jdbc:mysql://localhost:3306/springboot?characterEncoding=utf-8&useSSL=false");
            String name = encryptor.encrypt("test");
            String password = encryptor.encrypt("1");
            System.out.println("url:"+url);
            System.out.println("name:"+name);
            System.out.println("password:"+password);
//            Assert.assertTrue(name.length() > 0);
//            Assert.assertTrue(password.length() > 0);
        }


}
