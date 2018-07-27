package com.lc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by liuch on 2018/7/26.
 */
@Component
@RabbitListener(queues = "user.register.queue")
public class UserConsumer {
    private Logger logger = LoggerFactory.getLogger(UserConsumer.class);
    @RabbitHandler
    public void execute(Long userId)
    {
        logger.info("用户注册消费者【节点0】获取消息，用户编号：{}",userId);

        //...//自行业务逻辑处理
    }


}

