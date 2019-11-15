package com.java.service.impl;

import com.java.mapper.UserMapper;
import com.java.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * description: 业务层/或者叫服务层
 * author: ws
 * time: 2019/11/14 23:13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    //到dao层获取数据
    @Override
    public List<Map<String,Object>> selectAllUsers(){
        return userMapper.findAllUsers();
    }

    @Override
    public int saveBank(String username, Float money) {
        return userMapper.insertBank(username, money);
    }

}
