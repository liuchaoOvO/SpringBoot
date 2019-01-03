package com.lc.controller;

import com.github.pagehelper.Page;
import com.lc.entity.SysUser;
import com.lc.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by CoderTnT on 2018/7/31.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController
{
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    @GetMapping(value = "/login")
    public String login (HttpServletRequest request,Model model)
    {
        logger.info("get=====login");
        return "login";
    }
    @PostMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        return "index";
    }
    @GetMapping(value = "/regist")
    public String registUI () {
        return "regist";
    }
    @PostMapping(value = "/regist")
    public String regist (SysUser user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        boolean b = sysUserService.registUser(user);
        if (b)
        {
            return "index";
        } else return "regist";
    }
    //http://localhost:8888/user/getUserList?pageNum=1&pageSize=3
    @RequestMapping(value = "/getUserList", produces = "text/plain;charset=utf-8")
    public String getUserList(Integer pageNum, Integer pageSize, Model model)
    {
        Page<SysUser> userList = sysUserService.getUserList(pageNum, pageSize);
        model.addAttribute("userList", userList);
        return "/user/userList";
    }
    @GetMapping(value = "/admin")
    public String admin (Model model)
    {
        model.addAttribute("extraInfo", "你是admin");
        return "admin";
    }
}
