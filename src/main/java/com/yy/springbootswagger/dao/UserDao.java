package com.yy.springbootswagger.dao;

import com.yy.springbootswagger.entity.Users;
import com.yy.springbootswagger.request.UserAgeModel;
import com.yy.springbootswagger.request.UserModels;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @package: com.yy.springbootswagger.dao
 * @Description:
 * @Date: Created in  2018-01-30 19:02
 * @Author: yy
 */
public interface UserDao {
    /**
      * @Description: 根据id查询
      * @param:
      * @author: yy
      * @date 2018/2/1 0001 16:51
     */
    Users selectByPrarmyKey(@Param("id") Integer id);

    /**
      * @Description: 根据年龄查询
      * @param:
      * @author: yy
      * @date 2018/2/1 0001 16:51
     */
    List<Users> selectByAge(UserAgeModel user);

    /**
      * @Description: 新增用户
      * @param:
      * @author: yy
      * @date 2018/2/1 0001 16:51
     */
    int insertUser(Users user);

    /**
      * @Description: 更新用户
      * @param:
      * @author: yy
      * @date 2018/2/1 0001 16:51
     */
    int updateUser(UserModels user);

    /**
      * @Description: 根据用户名查询
      * @param:
      * @author: yy
      * @date 2018/2/1 0001 16:51
     */
    List<Users> selectByUsername(@Param("username") String username);

    int changePassword(@Param("username") String username,@Param("password") String password);
}
