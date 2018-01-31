package com.yy.springbootswagger.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @package: com.yy.springbootswagger.request
 * @Description:
 * @Date: Created in  2018-01-31 14:15
 * @Author: yy
 */
@ApiModel(value = "年龄")
public class UserAgeModel {
    @ApiModelProperty(value = "年龄",required = false)
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
