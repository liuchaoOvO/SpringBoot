package com.lc.controller;

import com.lc.entity.UserEntity;
import com.lc.jpa.UserJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.jar.JarEntry;

/**
 * Created by liuch on 2018/7/24.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserJPA userJPA;

    private final  static Logger logger= LoggerFactory.getLogger(UserController.class);
    @RequestMapping(value = "/list",method= RequestMethod.GET)
    public  List<UserEntity> list(){
        logger.debug("debug................日志中");
        logger.info("info................日志中");
        logger.error("error................日志中");
        return userJPA.findAll();
    }
    @RequestMapping(value = "/age",method= RequestMethod.GET)
    public  List<UserEntity> age(){

        return userJPA.nativeQuery(20);
    }
    @RequestMapping(value = "/name",method= RequestMethod.GET)
    public  String name(String name,String pwd){
        userJPA.deleteNative(name,pwd);
         return "删除成功";
    }
    @RequestMapping(value = "/cutPage",method= RequestMethod.GET)
    public  List<UserEntity> cutPage(int page){
        UserEntity userEntity=new UserEntity();
        userEntity.setIniPage(page);
        userEntity.setSize(2);
        userEntity.setSort("desc");
        //获取排序对象
        Sort.Direction sort_direction=Sort.Direction.ASC.toString().equalsIgnoreCase(userEntity.getSort())?Sort.Direction.ASC:Sort.Direction.DESC;
        Sort sort=new Sort(sort_direction,userEntity.getSidx());
        //创建分页对象
        PageRequest pageRequest=new PageRequest(userEntity.getIniPage()-1,userEntity.getSize(),sort);
        return userJPA.findAll(pageRequest).getContent();
    }
    @RequestMapping(value = "/save",method= RequestMethod.GET)
    public  String save(){
        UserEntity userEntity=new UserEntity();
        userEntity.setAddress("LN");
        userEntity.setAge(20);
        userEntity.setName("LC");
         userJPA.save(userEntity);
         return "添加用户成功";
    }
    @RequestMapping(value = "/delete",method= RequestMethod.GET)
    public  List<UserEntity> delete(Long id){
        userJPA.deleteById(id);
        return userJPA.findAll();
    }
}
