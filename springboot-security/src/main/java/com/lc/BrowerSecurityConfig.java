package com.lc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by liuchao on 2018/7/21.
 */
@Configuration
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {
    // BrowerSecurityConfig
    @Autowired
    private MyAuthenctiationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenctiationFailureHandler myAuthenticationFailureHandler;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //  BrowerSecurityConfig.java
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * http.authorizeRequests()
         .anyRequest().authenticated()
         .and().formLogin().loginPage("/login")
         //设置默认登录成功跳转页面
         .defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
         .and()
         //开启cookie保存用户数据
         .rememberMe()
         //设置cookie有效期
         .tokenValiditySeconds(60 * 60 * 24 * 7)
         //设置cookie的私钥
         .key("")
         .and()
         .logout()
         //默认注销行为为logout，可以通过下面的方式来修改
         .logoutUrl("/custom-logout")
         //设置注销成功后跳转页面，默认是跳转到登录页面
         .logoutSuccessUrl("")
         .permitAll();
         * @param http
         * @throws Exception
         */
        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
                .loginPage("/login.html")
               .loginProcessingUrl("/user/login")
                .successHandler(myAuthenticationSuccessHandler) // 自定义登录成功处理
                .failureHandler(myAuthenticationFailureHandler) // 自定义登录失败处理
                .and()
                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/login.html").permitAll()
                .antMatchers().permitAll()  // 设置所有人都可以访问登录页面
                .anyRequest()               // 任何请求,登录后可以访问
                .authenticated()
                .and()
                .csrf().disable();          // 关闭csrf防护
    }
}