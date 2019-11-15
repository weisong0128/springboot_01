package com.java.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * description: 这是dao层
 * author: ws
 * time: 2019/11/14 23:08
 */
public interface UserMapper {

    @Select("select * from banks;")
    List<Map<String,Object>> selectAllUsers();


    List<Map<String,Object>> findAllUsers();

    @Insert("insert into banks values(null,#{arg0},#{arg1})")
    int insertBank(String username,Float money);

}
