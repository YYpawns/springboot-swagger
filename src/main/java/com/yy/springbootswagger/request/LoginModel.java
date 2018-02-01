package com.yy.springbootswagger.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @package: com.yy.springbootswagger.request
 * @Description:
 * @Date: Created in  2018-02-01 15:52
 * @Author: yy
 */
@ApiModel(value = "登录")
public class LoginModel {
    @ApiModelProperty(value = "用户名",required = true)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
