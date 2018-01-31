package com.yy.springbootswagger.dao;

import com.yy.springbootswagger.entity.Users;
import com.yy.springbootswagger.request.UserModel;

/**
 * @package: com.yy.springbootswagger.dao
 * @Description:
 * @Date: Created in  2018-01-30 19:02
 * @Author: yy
 */
public interface UserDao {
    Users selectById(UserModel user);
}
