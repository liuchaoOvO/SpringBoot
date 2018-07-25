package com.lc.jpa;

import com.lc.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liuch on 2018/7/24.
 *  JpaRepository需要泛型接口参数，第一个参数是实体，第二则是主键的类型
 */
public interface UserJPA extends JpaRepository<UserEntity,Long>,JpaSpecificationExecutor<UserEntity>,Serializable{

    @Query(value="select * from t_user where t_age>?1  ",nativeQuery = true)
    public List<UserEntity> nativeQuery(int age);

    @Modifying
    @Transactional
    @Query(value="delete from t_user where t_name=?1 and t_pwd=?2  ",nativeQuery = true)
    public void deleteNative(String name,String password);
}
