package com.java.controller;

import com.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * description: 描述
 * author: ws
 * time: 2019/11/14 22:26
 */
//@RestController
@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @RequestMapping("/index.do")
    public String index(){
        return "index";
    }

    @RequestMapping("/findAllUser.do")  //这个地址就是接口
    public @ResponseBody List<Map<String,Object>> findAllUser(){
        System.out.println("=============================");
        return userService.selectAllUsers();
    }

    @RequestMapping("/addUser.do")  //这个地址就是接口
    public @ResponseBody int addUser(String username,Float money){
        System.out.println("=============================");
        return userService.saveBank(username, money);
    }
}
