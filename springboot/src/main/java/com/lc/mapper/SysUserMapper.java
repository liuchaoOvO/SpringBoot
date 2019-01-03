package com.lc.mapper;

import com.lc.entity.SysPermission;
import com.lc.entity.SysRole;
import com.lc.entity.SysRolePermisson;
import com.lc.entity.SysUser;
import org.apache.ibatis.annotations.*;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by liuch on 2018/7/31.
 */
@Mapper
public interface SysUserMapper {

    SysUser findUserByUsername(String username);

    List<SysRole> findRolesByUsername(String username);

    List<SysPermission> findPermissionsByUsername(String username);

    List<SysRolePermisson> findAllRolePermissoin();

    @Select("SELECT * FROM sys_user")
    Page<SysUser> getUserList();
    @Insert({"insert into sys_user(username,password)  values(#{username},#{password})"})
    Boolean registUser(SysUser user);
    @Update("update sys_user su set su.status=false where su.username=#{username}")
    void lockUser(String username);
    @Select("select su.status from sys_user su where su.username=#{username}")
    Boolean findUserStatusByUsername(String username);


    /**
     * 方式2：使用注解指定某个工具类的方法来动态编写SQL.
     */
    @SelectProvider(type = UserSqlProvider.class, method = "listByUsername")
    SysUser findUserByUsernameProvider(String username);

}