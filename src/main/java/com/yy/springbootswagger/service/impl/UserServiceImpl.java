package com.yy.springbootswagger.service.impl;

import com.yy.springbootswagger.dao.UserDao;
import com.yy.springbootswagger.entity.Users;
import com.yy.springbootswagger.request.LoginModel;
import com.yy.springbootswagger.request.UserAgeModel;
import com.yy.springbootswagger.request.UserModel;
import com.yy.springbootswagger.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<Users> selectByAge(UserAgeModel user) {
        return userDao.selectByAge(user);
    }

    @Override
    public int insertUser(Users user) {
        return userDao.insertUser(user);
    }

    @Override
    public int updateUser(Users user) {
        return userDao.updateUser(user);
    }

    @Override
    public Users selectByUsername(LoginModel user) {
        return userDao.selectByUsername(user);
    }
}
