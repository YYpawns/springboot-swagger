package com.yy.springbootswagger.service.impl;

import com.yy.springbootswagger.dao.UserDao;
import com.yy.springbootswagger.entity.Users;
import com.yy.springbootswagger.request.UserAgeModel;
import com.yy.springbootswagger.request.UserModels;
import com.yy.springbootswagger.service.UserService;
import com.yy.springbootswagger.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    public Users selectByPrarmyKey(Integer id) {
        return userDao.selectByPrarmyKey(id);
    }

    @Override
    public List<Users> selectByAge(UserAgeModel user) {
        return userDao.selectByAge(user);
    }

    @Override
    public int insertUser(Users user) {
        if(user.getDate() == null){
            user.setDate(new Date());
        }
        if(user.getSuccdate() == null){
            user.setSuccdate(new Date());
        }
        user.setPassword(MD5Util.md5(user.getPassword()));
        return userDao.insertUser(user);
    }

    @Override
    public int updateUser(UserModels user) {
        user.setPassword(MD5Util.md5(user.getPassword()));
        return userDao.updateUser(user);
    }

    @Override
    public Users selectByUsername(String username) {
        List<Users> list = userDao.selectByUsername(username);
        if(list == null || list.size() <= 0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public int changePassword(String username,String password) {
        return userDao.changePassword(username,password);
    }
}
