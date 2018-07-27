package com.lc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqConsumer1Application {
	static Logger logger = LoggerFactory.getLogger(RabbitmqConsumer1Application.class);
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqConsumer1Application.class, args);
		logger.info("【【【【【消息队列-消息消费者1号启动成功.】】】】】");
	}
}
