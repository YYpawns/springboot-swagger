package com.yy.springbootswagger.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @package: com.yy.springbootswagger.request
 * @Description:
 * @Date: Created in  2018-02-06 15:12
 * @Author: yy
 */
@ApiModel("更新用户")
public class UserModels {
    @ApiModelProperty(value = "id",required = true)
    private Integer id;
    @ApiModelProperty(value = "username",required = false)
    private String username;
    @ApiModelProperty(value = "age",required = false)
    private Integer age;
    @ApiModelProperty(value = "date",required = false)
    private Date date;
    @ApiModelProperty(value = "succdate",required = false)
    private Date succdate;
    @ApiModelProperty(value = "password",required = false)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
