package com.java.service;

import java.util.List;
import java.util.Map;

/**
 * description: 描述
 * author: ws
 * time: 2019/11/14 23:17
 */
public interface UserService {
    List<Map<String,Object>> selectAllUsers();

    int saveBank(String username,Float money);
}
