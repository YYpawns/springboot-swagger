package com.yy.springbootswagger.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @package: com.yy.springbootswagger.request
 * @Description:
 * @Date: Created in  2018-02-06 14:07
 * @Author: yy
 */
@ApiModel("用户名")
public class UsernameModel {
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
