package com.yy.springbootswagger.service.impl;

import com.yy.springbootswagger.dao.UserDao;
import com.yy.springbootswagger.entity.Users;
import com.yy.springbootswagger.request.UserModel;
import com.yy.springbootswagger.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @package: com.yy.springbootswagger.service.impl
 * @Description:
 * @Date: Created in  2018-01-30 19:01
 * @Author: yy
 */
@Service
public class UserServiceImpl  implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public Users selectById(UserModel user) {
        return userDao.selectById(user);
    }
}
