package com.lc.config;

import com.lc.filter.ValidateCodeFilter;
import com.lc.handler.EntryPointUnauthorizedHandler;
import com.lc.handler.MyAuthenticationFailureHandler;
import com.lc.handler.MyAuthenticationSuccessHandler;
import com.lc.handler.RestAccessDeniedHandler;
import com.lc.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by CoderTnT on 2018/7/31.
 */
@Configuration           // 声明为配置类
@EnableWebSecurity       // 启用 Spring Security web 安全的功能
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final static Logger logger = LoggerFactory.getLogger(MyWebSecurityConfig.class);
    /**
     * 通过 实现UserDetailService 来进行验证
     */
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Autowired
    private  PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ValidateCodeFilter validateCodeFilter;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //校验用户
        auth.userDetailsService(sysUserService)
                .passwordEncoder(bCryptPasswordEncoder);
    }
        /**
         * 自定义配置
         */
        @Override
        protected void configure (HttpSecurity http) throws Exception {
            http.authorizeRequests()//配置安全策略
                    .antMatchers("/index","/user/login", "/user/regist", "/qrcode/generateqrcode","/kaptcha").permitAll()
                    .antMatchers("/css/**", "/js/**", "/images/**").permitAll()
                    .antMatchers("/user/admin/**").hasRole("ADMIN") //以 "/admin/" 开头的URL只能由拥有 "ROLE_ADMIN"角色的用户访问。请注意我们使用 hasRole 方法，没有使用 "ROLE_" 前缀.
                    .anyRequest().authenticated();//其余的所有请求都需要验证
                   // .and()                              //使用and()方法相当于XML标签的关闭
                    //关闭验证码过滤器
                   // .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class);
            http.formLogin()
                    .loginPage("/user/login")            //拦截后get请求跳转的页面,指定的登录页的路径
                    .loginProcessingUrl("/user/login")   //与登录页面请求的action行为一致，即表示登录操作行为的Url
                    .successHandler(myAuthenticationSuccessHandler)
                    .failureHandler(myAuthenticationFailureHandler)
                    .permitAll() //我们必须允许所有用户访问我们的登录页（例如为验证的用户），这个formLogin().permitAll()方法允许基于表单登录的所有的URL的所有用户的访问。
                    .and()
                    .logout().permitAll()
                    .and()
                    //关闭跨站请求防护
                    .csrf().disable();
        }

}
