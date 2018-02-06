package com.yy.springbootswagger.controller;

import com.yy.springbootswagger.entity.Users;
import com.yy.springbootswagger.exception.ErrosMessage;
import com.yy.springbootswagger.exception.MyException;
import com.yy.springbootswagger.request.*;
import com.yy.springbootswagger.service.UserService;
import com.yy.springbootswagger.util.MD5Util;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @package: com.yy.springbootswagger.controller
 * @Description:
 * @Date: Created in  2018-01-30 18:59
 * @Author: yy
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户登录")
    @ResponseBody
    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public Object loginUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute LoginModel model) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            Users use = userService.selectByUsername(model.getUsername());
            if (use == null) {
                return ErrosMessage.user_not_exist;
            }
            if (!model.getUsername().equals(use.getUsername()) || !MD5Util.md5(model.getPassword()).equals(use.getPassword())) {
                return  ErrosMessage.username_or_password_error;
            }
            //用户信息存到session,只保存用户名
            request.getSession().setAttribute("user", use.getUsername());
            return ErrosMessage.login_success;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ErrosMessage.login_fial);
        }
    }

    @ApiOperation(value = "验证登录")
    @ResponseBody
    @RequestMapping(value = "/checkLoginUser", method = RequestMethod.POST)
    public Object checkLoginUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute LoginModel model) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            //从session中获取用户信息
            String user1 = (String) request.getSession().getAttribute("user");
            //有信息返回成功
            if (model.getUsername().equals(user1)) {
                return ErrosMessage.login_success + "-session";
            }
            //没有查数据库
            Users use = userService.selectByUsername(model.getUsername());
            if (use == null  || !use.getUsername().equals(model.getUsername())) {
                return ErrosMessage.user_not_exist;
            }
            if(!MD5Util.md5(model.getPassword()).equals(use.getPassword()) || !use.getUsername().equals(model.getUsername())){
                return ErrosMessage.username_or_password_error;
            }
            return ErrosMessage.login_success;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ErrosMessage.login_fial);
        }
    }

    @ApiOperation(value = "根据id查询用户")
    @ResponseBody
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public Object getUser(HttpServletResponse response, @ModelAttribute UserModel user) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            Users users = userService.selectByPrarmyKey(user.getId());
            if (users == null) {
                return ErrosMessage.user_not_exist;
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ErrosMessage.query_user_failed);
        }
    }

    @ApiOperation(value = "根据年龄查询用户")
    @ResponseBody
    @RequestMapping(value = "/getUserByAge", method = RequestMethod.POST)
    public Object getUserByAge(HttpServletResponse response, @ModelAttribute UserAgeModel model) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            List<Users> users = userService.selectByAge(model);
            if (users == null || users.isEmpty()) {
                return ErrosMessage.query_user_failed;
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ErrosMessage.query_user_failed);
        }
    }

    @ApiOperation(value = "新增用户")
    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Object addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Users user) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            //查询缓存
            String username = (String) request.getSession().getAttribute("user");
            if (!StringUtils.isEmpty(username) && username.equals(user.getUsername())) {
                return ErrosMessage.user_exist;
            }
            Users users = userService.selectByUsername(user.getUsername());
            if (users != null) {
                return ErrosMessage.user_exist;
            }
            int count = userService.insertUser(user);
            if (count <= 0) {
                return ErrosMessage.add_user_fial;
            }
            return ErrosMessage.add_user_success;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ErrosMessage.add_user_fial);
        }
    }

    @ApiOperation(value = "修改用户")
    @ResponseBody
    @RequestMapping(value = "/changeUser", method = RequestMethod.POST)
    public Object changeUser(HttpServletResponse response, @ModelAttribute UserModels model) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            Users users = userService.selectByPrarmyKey(model.getId());
            if(users == null){
                return ErrosMessage.user_not_exist;
            }
            int count = userService.updateUser(model);
            if (count <= 0) {
                return ErrosMessage.update_user_fial;
            }
            return ErrosMessage.update_user_success;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ErrosMessage.update_user_fial);
        }
    }

    @ApiOperation(value = "修改登录密码")
    @ResponseBody
    @RequestMapping(value = "/changeLoginPassword", method = RequestMethod.POST)
    public Object changeLoginPassword(HttpServletRequest request, HttpServletResponse response, @ModelAttribute UsernameModel model) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            Users users = userService.selectByUsername(model.getUsername());
            if (users == null) {
                return ErrosMessage.user_not_exist;
            }
            int count = userService.changePassword(model.getUsername(), MD5Util.md5(model.getPassword()));
            if (count <= 0) {
                throw new MyException(ErrosMessage.change_password_fial);
            }
            return ErrosMessage.change_password_success;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ErrosMessage.change_password_fial);
        }
    }

    @ApiOperation(value = "清除session")
    @ResponseBody
    @RequestMapping(value = "/removeSession", method = RequestMethod.POST)
    public Object removeSession(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            request.getSession().invalidate();
            return ErrosMessage.remove_session_success;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ErrosMessage.remove_session_fail);
        }
    }

}
