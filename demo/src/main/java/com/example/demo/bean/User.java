package com.example.demo.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 用户信息
 */
public class User {

    /**
     * 主键
     */
    @JSONField(name = "Id")
    private Integer id;

    /**
     * 用户名
     */
    @JSONField(name = "UserName")
    private String userName;

    /**
     * 密码
     */
    @JSONField(name = "Pasword")
    private String pasword;

    /**
     * 地址
     */
    @JSONField(name = "Address")
    private String address;

    /**
     * 性别
     */
    @JSONField(name = "Sex")
    private String sex;

    /**
     * 电话号码
     */
    @JSONField(name = "PhoneNum")
    private String phoneNum;

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getUserName () {
        return userName;
    }

    public void setUserName (String userName) {
        this.userName = userName;
    }

    public String getPasword () {
        return pasword;
    }

    public void setPasword (String pasword) {
        this.pasword = pasword;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getSex () {
        return sex;
    }

    public void setSex (String sex) {
        this.sex = sex;
    }

    public String getPhoneNum () {
        return phoneNum;
    }

    public void setPhoneNum (String phoneNum) {
        this.phoneNum = phoneNum;
    }

}
