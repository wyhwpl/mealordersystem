package com.meal.controller;

import com.meal.commons.CheckResult;
import com.meal.pojo.Rider;
import com.meal.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: MealOrderPlatform
 * @Date: 2019/1/3 19:28
 * @Author: QiXiao
 * @Description:
 */
@Controller
public class RiderSignController {
    @Autowired
    private RegisterService registerService;
    @RequestMapping(value = "/rider-signup",method = RequestMethod.POST)
    @ResponseBody
    public CheckResult signup(@RequestParam(value = "phone")String phone,
                              @RequestParam(value = "name")String name,
                              @RequestParam(value = "password")String password,
                              @RequestParam(value = "gender")String sex){
        Rider rider=new Rider();
        rider.setPhone(phone);
        rider.setUsername(name);
        rider.setSex(sex);
        rider.setPassword(password);
        return registerService.register(rider);
    }

}
