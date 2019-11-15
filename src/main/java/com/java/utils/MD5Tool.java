package com.java.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * description: md5工具类
 * author: ws
 * time: 2019/11/15 23:13
 */
public class MD5Tool {
    //16个不同的字符
    private static String[] digital = {"0","1","2","3","5","6","7","8","9","a","b","c","d","e","f","g"};

    /**
     * 初始化生成的MD5值，固定
     * @param txt
     * @return
     * @throws Exception
     */
    private static String initMD5(String txt) throws Exception{
        //明文
//        String txt = "123456";  //这里明文经过MessageDigest加密后是16位
        //密文
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //digest(byte[] bytes):参数接收明文字节数组，返回一个密文字节数组
        //返回的字节数组中，数值在范围：-256 -- +256
        byte[] bytes = md5.digest(txt.getBytes("UTF-8"));
        System.out.println(bytes);
        System.out.println(Arrays.toString(bytes));
        System.out.println("长度=" + bytes.length);
        //每个数字从digital数组中取两个不同的字符
        String miWen = "";
        for(byte temp : bytes){
            //需要经过temp算出两个不同的下标（下标取值范围为0-15）
            int tp = temp;
            if(tp < 0 ){
                tp+=256;
            }
            int i = tp/16;
            int j = tp%16;
            miWen+=digital[i] + digital[j];
        }
//        System.out.println("加密后=" + miWen);
        return miWen;

    }

    /**
     * 最终给人看的处理后每次都不一样的MD5值
     * @param txt
     * @return
     */
    public static String finalMD5(String txt) throws Exception{
        return initMD5(initMD5(initMD5(txt)+txt+"fenghuo")+txt+"weisong");
    }

}



