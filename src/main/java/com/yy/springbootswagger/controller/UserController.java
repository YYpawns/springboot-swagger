package com.yy.springbootswagger.controller;

import com.alibaba.fastjson.JSONObject;
import com.yy.springbootswagger.entity.Users;
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

    @ApiOperation(value = "查询用户")
    @ResponseBody
    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public Object getUser(HttpServletResponse response, @ModelAttribute UserModel user){
        response.setHeader("Access-Control-Allow-Origin", "*");
        try{
            Users users = userService.selectById(user);
            return users;
        }catch (Exception e){
            e.printStackTrace();
            return  "error";
        }
    }

    @ApiOperation(value = "根据年龄查询用户")
    @ResponseBody
    @RequestMapping(value = "/getUserByAge",method = RequestMethod.POST)
    public Object getUserByAge(HttpServletResponse response, @ModelAttribute UserAgeModel user){
        response.setHeader("Access-Control-Allow-Origin", "*");
        try{
            List<Users> users = userService.selectByAge(user);
            return users;
        }catch (Exception e){
            e.printStackTrace();
            return  "error";
        }
    }
}
