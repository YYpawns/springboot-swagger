package com.yy.springbootswagger.entity;

import java.util.Date;

/**
 * @package: com.yy.springbootswagger.entity
 * @Description: user实体类
 * @Date: Created in  2018-01-30 18:51
 * @Author: yy
 */
public class Users {

    private Integer id;
    private String username;
    private Integer age;
    private Date date;
    private Date succdate;

    public Date getSuccdate() {
        return succdate;
    }

    public void setSuccdate(Date succdate) {
        this.succdate = succdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
