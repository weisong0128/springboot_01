package com.java.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: 数据校验
 * author: ws
 * time: 2019/11/17 16:25
 */
public class FieldValidator {

    /**
     * 如果返回null，则数据格式完全正确
     * @param br
     * @return
     */
    public static Map<String,Object> validate(BindingResult br){
        boolean flag = br.hasErrors();
        if(flag){//数据格式有错误
            List<FieldError> errorList = br.getFieldErrors();
            //FieldError对象：封装了发生错误的属性名，还有错误信息message
            Map<String,Object> errorMap = new HashMap<String,Object>();
            for (FieldError fe : errorList) {
                //1、取出发生错误字段的属性名
                String field = fe.getField();
                //2、取出错误信息
                String defaultMessage = fe.getDefaultMessage();
                errorMap.put(field,defaultMessage);
            }
            return errorMap;
        }else{//数据格式完全正确
            return null;
        }
    }

}
