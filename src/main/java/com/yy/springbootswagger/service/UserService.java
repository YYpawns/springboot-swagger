package com.yy.springbootswagger.service;

import com.yy.springbootswagger.entity.Users;
import com.yy.springbootswagger.request.UserAgeModel;
import com.yy.springbootswagger.request.UserModels;

import java.util.List;

/**
 * @package: com.yy.springbootswagger.service
 * @Description:
 * @Date: Created in  2018-01-30 19:01
 * @Author: yy
 */
public interface UserService {
    /**
      * @Description: 根据id查询
      * @param:
      * @author: yy
      * @date 2018/2/1 0001 16:50
     */
    Users selectByPrarmyKey(Integer id);

    /**
      * @Description: 根据年龄查询
      * @param:
      * @author: yy
      * @date 2018/2/1 0001 16:50
     */
    List<Users> selectByAge(UserAgeModel user);

    /**
      * @Description: 新增用户
      * @param:
      * @author: yy
      * @date 2018/2/1 0001 16:49
     */
    int insertUser(Users user);

    /**
      * @Description: 更新用户
      * @param:
      * @author: yy
      * @date 2018/2/1 0001 16:49
     */
    int updateUser(UserModels user);

    /**
      * @Description: 用户名查询
      * @param:
      * @author: yy
      * @date 2018/2/1 0001 16:49
     */
    Users selectByUsername(String username);

    int changePassword(String username,String password);
}
