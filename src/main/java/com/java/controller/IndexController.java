package com.java.controller;

import com.java.pojo.QQ;
import com.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/index1")
    public String index1(){
        return "index1";
    }

    @RequestMapping("/index2")
    public String index2(Model model){
        List<Map<String, Object>> userList = userService.selectAllUsers();
        model.addAttribute("userList", userList);
        return "index2";
    }

    @RequestMapping("/index3")
    public String index3(Model model){
        List<Map<String, Object>> userList = userService.selectAllUsers();
        model.addAttribute("userList", userList);
        return "index3";
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

    @RequestMapping("/addQQ.do")
    public @ResponseBody boolean addQQ(@RequestBody  QQ qqInfo){
        System.out.println("----------------------------");
        System.out.println("QQ=" + qqInfo);
        return true;
    }

}
