package com.meal.controller;

import com.meal.commons.CheckResult;
import com.meal.pojo.User;
import com.meal.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: MealOrderPlatform
 * @Date: 2018/12/20 20:08
 * @Author: QiXiao
 * @Description:
 */
@Controller
public class SignUpController {
    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/user-signup",method= RequestMethod.POST)
    @ResponseBody
    public CheckResult SignUpHandler(HttpServletRequest request,
                                     HttpServletResponse response,
                                     @RequestParam(value = "phone")String phone,
                                     @RequestParam(value = "password")String password,
                                     @RequestParam(value = "name")String name,
                                     @RequestParam(value="gender")String gender){


        // System.out.println(name+gender);
        User user=new User();
        user.setPhone(phone);
        user.setPassword(password);
        user.setUsername(name);
        user.setSex(gender);
        return registerService.registerHandler(user);
    }
}
