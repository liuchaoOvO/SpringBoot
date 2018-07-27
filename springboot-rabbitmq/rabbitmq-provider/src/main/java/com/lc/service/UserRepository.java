package com.lc.service;

import com.lc.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liuch on 2018/7/26.
 */
public interface UserRepository
        extends JpaRepository<UserEntity,Long>
{
}