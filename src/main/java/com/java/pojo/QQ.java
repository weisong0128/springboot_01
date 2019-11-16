package com.java.pojo;

import java.io.Serializable;

/**
 * description: 描述
 * author: ws
 * time: 2019/11/16 22:26
 */
//lombok包的注解，可以实现任意组合的构造方法

public class QQ implements Serializable{
    private String nick;
    private String pwd;
    private String phone;
    private String em;
    private Integer age;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "QQ{" +
                "nick='" + nick + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                ", em='" + em + '\'' +
                ", age=" + age +
                '}';
    }
}
