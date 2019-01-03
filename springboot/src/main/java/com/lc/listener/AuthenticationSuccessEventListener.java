package com.lc.listener;

import com.lc.handler.MyAuthenticationSuccessHandler;
import com.lc.service.SysUserService;
import com.sun.tools.corba.se.idl.InterfaceGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author: CoderTnT
 * @date: 2018/9/10
 */
@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent>
{
    @Autowired
    private SysUserService sysUserService;
    private final static Logger logger = LoggerFactory.getLogger(AuthenticationSuccessEventListener.class);
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
           logger.info("=====监听成功程序=============");
    }
}