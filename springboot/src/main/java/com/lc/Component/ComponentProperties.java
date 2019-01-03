package com.lc.Component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liuchaoOvO on 2018/12/28
 * 读取yml文件中的参数值  映射方法
 */
/*@Component
@ConfigurationProperties(prefix = "spring.rabbitmq")*/
public class ComponentProperties
{
    private String host;

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    private int port;
    private String username;
    private String password;



}
