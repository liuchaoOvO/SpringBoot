package com.lc.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by CoderTnT on 2018/8/24.
 */
public class MyAuthenticationException extends AuthenticationException
{

    public MyAuthenticationException(String msg)
    {
        super(msg);
    }
}
