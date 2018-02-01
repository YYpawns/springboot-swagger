package com.yy.springbootswagger.controller;

import com.yy.springbootswagger.entity.Users;
import com.yy.springbootswagger.exception.ErrosMessage;
import com.yy.springbootswagger.exception.MyException;
import com.yy.springbootswagger.request.LoginModel;
import com.yy.springbootswagger.request.UserAgeModel;
import com.yy.springbootswagger.request.UserModel;
import com.yy.springbootswagger.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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
    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    public Object loginUser(HttpServletRequest request,HttpServletResponse response, @ModelAttribute LoginModel user){
        response.setHeader("Access-Control-Allow-Origin", "*");
        try{
            Users use = userService.selectByUsername(user);
            if(use == null){
                throw new MyException(ErrosMessage.user_not_exist);
            }
            //用户信息存到session,只保存用户名
            request.getSession().setAttribute("user",user.getUsername());
            return ErrosMessage.login_success;
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException(ErrosMessage.login_fial);
        }
    }

    @ApiOperation(value = "验证登录")
    @ResponseBody
    @RequestMapping(value = "/checkLoginUser",method = RequestMethod.POST)
    public Object checkLoginUser(HttpServletRequest request,HttpServletResponse response, @ModelAttribute LoginModel user){
        response.setHeader("Access-Control-Allow-Origin", "*");
        try{
            //从session中获取用户信息
            String user1 = (String) request.getSession().getAttribute("user");
            //有信息返回成功
            if(user.getUsername().equals(user1)){
                return ErrosMessage.login_success + "-session";
            }
            //没有查数据库
            Users use = userService.selectByUsername(user);
            if(use == null && !use.getUsername().equals(user.getUsername())){
                throw new MyException(ErrosMessage.user_not_exist);
            }
            return ErrosMessage.login_success;
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException(ErrosMessage.login_fial);
        }
    }

    @ApiOperation(value = "根据id查询用户")
    @ResponseBody
    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public Object getUser(HttpServletResponse response, @ModelAttribute UserModel user){
        response.setHeader("Access-Control-Allow-Origin", "*");
        try{
            Users users = userService.selectById(user);
            if(users == null){
                throw new MyException(ErrosMessage.user_not_exist);
            }
            return users;
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException(ErrosMessage.query_user_failed);
        }
    }

    @ApiOperation(value = "根据年龄查询用户")
    @ResponseBody
    @RequestMapping(value = "/getUserByAge",method = RequestMethod.POST)
    public Object getUserByAge(HttpServletResponse response, @ModelAttribute UserAgeModel user){
        response.setHeader("Access-Control-Allow-Origin", "*");
        try{
            List<Users> users = userService.selectByAge(user);
            if(users == null || users.isEmpty()){
                throw new MyException(ErrosMessage.query_user_failed);
            }
            return users;
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException(ErrosMessage.query_user_failed);
        }
    }

    @ApiOperation(value = "新增用户")
    @ResponseBody
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Object addUser(HttpServletResponse response, @ModelAttribute Users user){
        response.setHeader("Access-Control-Allow-Origin", "*");
        try{
            if(user.getDate() == null){
                user.setDate(new Date());
            }
            if(user.getSuccdate() == null){
                user.setSuccdate(new Date());
            }
            int count = userService.insertUser(user);
            if(count <= 0){
                throw new MyException(ErrosMessage.add_user_fial);
            }
            return ErrosMessage.add_user_success;
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException(ErrosMessage.add_user_fial);
        }
    }

    @ApiOperation(value = "修改用户")
    @ResponseBody
    @RequestMapping(value = "/changeUser",method = RequestMethod.POST)
    public Object cahngeUser(HttpServletResponse response, @ModelAttribute Users user){
        response.setHeader("Access-Control-Allow-Origin", "*");
        try{
            int count = userService.updateUser(user);
            if(count <= 0){
                throw new MyException(ErrosMessage.update_user_fial);
            }
            return ErrosMessage.update_user_success;
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException(ErrosMessage.update_user_fial);
        }
    }


}
