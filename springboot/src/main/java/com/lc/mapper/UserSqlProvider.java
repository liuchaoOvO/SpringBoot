package com.lc.mapper;

import com.lc.entity.SysUser;

/**
 * @author liuchaoOvO on 2019/1/2
 */
public class UserSqlProvider
{
    public String listByUsername(String username){
        return "select * from sys_user where username=#{username}" ;
    }
}
