package com.java.pojo;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * description: 描述
 * author: ws
 * time: 2019/11/16 22:26
 */
//lombok包的注解，可以实现任意组合的构造方法

public class QQ implements Serializable{
    @Pattern(regexp = ".{4,10}", message = "*昵称不满足格式要求")
    private String nick;    //4-10位任意字符
    @Pattern(regexp = ".{6,16}", message = "*密码不满足格式要求")
    private String pwd;     //6-16位任意字符
    @Pattern(regexp = "1[35789]\\d{9}", message = "*手机号格式错误")
    private String phone;
    @Email(message = "*邮箱格式错误")
    private String em;
    @Min(value=1L, message = "*亲，您还没出生吧")
    @Max(value=150, message = "*亲，您还没死嘛")
    private Integer age;    //1-150 -1:亲您还没有出生吧     >150亲您还没死嘛

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

    public QQ(String nick, String pwd, String phone, String em, Integer age) {
        this.nick = nick;
        this.pwd = pwd;
        this.phone = phone;
        this.em = em;
        this.age = age;
    }

    public QQ() {
        super();
    }
}
