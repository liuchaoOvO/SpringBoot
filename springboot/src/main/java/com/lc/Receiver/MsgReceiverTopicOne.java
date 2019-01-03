package com.lc.Receiver;

import com.lc.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author liuchaoOvO on 2018/12/28
 */
@Component
@RabbitListener(queues = RabbitConfig.TopicMsg)
public class MsgReceiverTopicOne
{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String content) {
        logger.info("接收处理MsgReceiverTopicOne当中的消息： " + content);
    }

}

