package com.yy.springbootswagger.service;

import com.yy.springbootswagger.entity.Users;
import com.yy.springbootswagger.request.UserAgeModel;
import com.yy.springbootswagger.request.UserModel;

import java.util.List;

/**
 * @package: com.yy.springbootswagger.service
 * @Description:
 * @Date: Created in  2018-01-30 19:01
 * @Author: yy
 */
public interface UserService {
    Users selectById(UserModel user);

    List<Users> selectByAge(UserAgeModel user);
}
