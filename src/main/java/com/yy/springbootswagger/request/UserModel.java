package com.yy.springbootswagger.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @package: com.yy.springbootswagger.request
 * @Description:
 * @Date: Created in  2018-01-30 19:09
 * @Author: yy
 */
@ApiModel(value = "用户")
public class UserModel {
    @ApiModelProperty(value = "主键id",required = true)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
