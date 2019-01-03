package com.lc.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lc.Producer.MsgProducer;
import com.lc.entity.SysRole;
import com.lc.entity.SysUser;
import com.lc.mapper.SysUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by CoderTnT on 2018/7/31.
 */
@Component
public class SysUserService implements UserDetailsService {
    private final static Logger logger = LoggerFactory.getLogger(SysUserService.class);
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private RedisService  stringRedisService;
    @Autowired
    private MsgProducer  msgProducer;
    //注册用户
    public boolean registUser(SysUser user){
        if(stringRedisService.get(user.getUsername()) != null){

            //msgProducer.sendMsg("注册失败===rabbitmq");
            msgProducer.sendTopicMsg("fail");
            return false;
        }else{
            sysUserMapper.registUser(user);
            stringRedisService.set(user.getUsername(),user);
           // msgProducer.sendMsg("注册成功===rabbitmq");
           // msgProducer.sendTopicMsg("success");
            msgProducer.sendFanoutMsgs("sendFanoutMsgs===");
            return true;
        }
    }
    //分页查询所有用户
    public Page<SysUser> getUserList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        Page<SysUser> userList= sysUserMapper.getUserList();
        for(SysUser user:userList){
            System.out.println("姓名为==="+user.getUsername()+"====");
        }
        return userList;
    }
    public SysUser findUserByUsername(String username){
         SysUser sysUser=sysUserMapper.findUserByUsername(username);
        if(sysUser!=null){
            return sysUser;
        }
        return null;
    }
    public boolean lockUser(String username){
        SysUser sysUser=sysUserMapper.findUserByUsername(username);
        if(sysUser!=null)
        {
            sysUserMapper.lockUser(username);
            return true;
        }
        return false;
    }
    //重写UserDetailsService的UserDetails方法@param username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user;
         // 从数据库取
//         user = sysUserMapper.findUserByUsername(username);
        user = sysUserMapper.findUserByUsernameProvider(username);
        System.out.println("findUserByUsernameProvider:====");
        if(user == null)
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        List<SysRole> sysRoles = sysUserMapper.findRolesByUsername(user.getUsername());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (SysRole sysRole : sysRoles) {
            //封装用户信息和角色信息 到 SecurityContextHolder全局缓存中
            grantedAuthorities.add(new SimpleGrantedAuthority(sysRole.getName()));
        }
        System.out.println("用户名"+user.getUsername()+"密码："+user.getPassword());
        for(int i=0;i<grantedAuthorities.size();i++){
            System.out.println("权限:"+grantedAuthorities.get(i));
        }
        Boolean status=sysUserMapper.findUserStatusByUsername(username);
        System.out.println("状态:"+status);
        return new User(user.getUsername(),  user.getPassword(), true, true, true, status, grantedAuthorities);
    }
}
