package com.lc.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by CoderTnT on 2018/8/2.
 */

@Component
public class MyAuthenticationSuccessHandler
        extends SimpleUrlAuthenticationSuccessHandler
{
    private final static Logger logger = LoggerFactory.getLogger(MyAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        logger.info("认证成功");
      /*  String Url="http://www.baidu.com";
        String reIndex="/index";
       response.sendRedirect(reIndex);*/
        super.onAuthenticationSuccess(request,response,authentication);

    }



}


