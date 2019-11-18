package com.java.controller;

import com.java.service.UserService;
import com.java.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * description:
 * author: ws
 * time: 2019/11/18 21:29
 */
public class Test {
    public static void main(String[] args) {
        UserService u = new UserServiceImpl();
        List<Map<String, Object>> maps = u.selectAllUsers();
        System.out.println(maps);
    }
}
