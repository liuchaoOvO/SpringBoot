package com.lc.config;

import lombok.Getter;

/**
 * Created by liuch on 2018/7/26.
 */
@Getter
public enum ExchangeEnum
{
    /**
     * 用户注册交换配置枚举
     */
    USER_REGISTER("user.register.topic.exchange");
    private String value;

    ExchangeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

