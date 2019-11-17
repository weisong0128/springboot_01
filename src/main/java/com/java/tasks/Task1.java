package com.java.tasks;

import com.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：15:53
 */
@Component
public class Task1 {
    @Autowired
    private UserService userService;

    //任务调度
    //@Scheduled(fixedRate = 1000L)
    @Scheduled(cron="0/3 5 16 * * *")
    public void printTime(){
        //System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        List<Map<String, Object>> userList = userService.selectAllUsers();
        System.out.println(userList);

    }

}
