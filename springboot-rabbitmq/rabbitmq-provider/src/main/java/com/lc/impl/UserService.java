package com.lc.impl;

import com.lc.config.ExchangeEnum;
import com.lc.config.QueueEnum;
import com.lc.entity.UserEntity;
import com.lc.service.QueueMessageService;
import com.lc.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by liuch on 2018/7/26.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    @Autowired
    private UserRepository userRepository;
    /**
     * 消息队列业务逻辑实现
     */
    @Autowired
    private QueueMessageService queueMessageService;

    /**
     * 保存用户
     * 并写入消息队列
     *
     * @param userEntity
     * @return
     */
    public Long save(UserEntity userEntity) throws Exception {
        /**
         * 保存用户
         */
        userRepository.save(userEntity);
        /**
         * 将消息写入消息队列
         */
        queueMessageService.send(userEntity.getId(), ExchangeEnum.USER_REGISTER, QueueEnum.USER_REGISTER);

        return userEntity.getId();
    }

}