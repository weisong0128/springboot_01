package com.java.controller;

import com.java.pojo.QQ;
import com.java.service.UserService;
import com.java.utils.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @RequestMapping(value = "/index1",method = RequestMethod.GET)
    public String index1(){

        return "index1"; //代表转发到index1下，至于具体在哪个路径下看视图解析器配置
        //如果jsp路径不在视图解析器指定路径下，则使用重定向
        //return "redirect:/registerQQ.jsp"
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

    //------------------------文件上传----------------------------
    //文件上传是往数据库里存的，但往数据库里存的永远是哪个绑定的地址，图片肯定不是放在数据库里的
    //在map集合里，返回一个图片地址和状态码(下载成功or失败)
    //@RequestParam(name="bigHeadImg"):表示把jsp中名字叫bigHeadImg的图片传给后面的file参数
    @RequestMapping("/uploadFile.do")
    public @ResponseBody  Map<String,Object> uploadFile(@RequestParam(name="bigHeadImg") MultipartFile file){
        //定义一个map集合，存放图片的相对路径及图片的状态（是否上传成功）
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("status","0");//代表图片存成功


        try {
            //图片的名字(.jpg .png .docx，因为有重名原因，我们还是用UUID)
            //1.获取文件的原始名字
            String orgName = file.getOriginalFilename();
            //2.获取后缀名
            int lastDocIndex = orgName.lastIndexOf(".");
            String ext = orgName.substring(lastDocIndex);   //得到后缀名
            //3.生成文件名
            String fileName = UUID.randomUUID().toString() + ext;
            //4.生成多级目录,利用SimpleDataFormat工具类
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd\\HH\\mm\\ss");
            String dir = sdf.format(d);
            System.out.println(dir);

            //5.动态生成多级文件夹
            File manyFirs = new File("G:\\uploads\\" + dir);
            if(!manyFirs.exists()){
                manyFirs.mkdirs();
            }
            //图片保存的位置：D:\\upload\\20181215\\13\\55\\xxx.jpg
            //6.开始保存图片
            file.transferTo(new File("G:\\uploads\\" + dir + "\\" + fileName));
            //存成功后记录下图片存的地址
            resultMap.put("imgUrl",dir+fileName);
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            //在这里捕捉，如果进入catch，则resultMap key的值为1
            resultMap.put("status","1");//代表图片存失败
            return resultMap;
        }
    }



    //--------------------------后台数据校验(JSR303)------------------------
    //相当于重定向的作用
    @RequestMapping("/qq.do")
    public String toRegisterQQ(){
        return "registerQQ";
    }

    @RequestMapping("addQQInfo.do")
    public String addQQInfo(@Valid QQ qqInfo, BindingResult br, Model model){
        //开始调用业务层service
        //如果数据格式完全正确，则接着调用后台业务层
        Map<String, Object> errorMap = FieldValidator.validate(br);
        if(errorMap!=null){//有错误信息
            //带错误信息过去
            model.addAttribute("errorMap",errorMap);
            model.addAttribute("qqInfo",qqInfo);
            return "registerQQ";    //转发到registerQQ.jsp界面
        }
        return "success";       //转发到success.jsp界面

    }

    //-----------------------操作mongodb-----------------------------------
//    @Autowired
//    private MongoOperations mongoOperations;
//
//    @RequestMapping("/saveData2Mongo.do")
//    public @ResponseBody boolean saveData2Mongo(){
//        try {
//            QQ qq1 = new QQ("aaa","123","110","123@163.com",18);
//            mongoOperations.save(qq1);  //如何没有QQ集合（表），则会在mongo库中创建一个QQ集合
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }


}
