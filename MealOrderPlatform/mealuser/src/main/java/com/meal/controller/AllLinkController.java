package com.meal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: MealOrderPlatform
 * @Date: 2018/12/20 20:00
 * @Author: QiXiao
 * @Description:
 */
@Controller
public class AllLinkController {
    @RequestMapping(value = "/entry",method= RequestMethod.GET)
    public String entry(){
        return "entry.html";
    }

    @RequestMapping(value = "/user-info",method= RequestMethod.GET)
    public String userInfo(){
        return "user-info.html";
    }

    @RequestMapping(value = "/user-order",method= RequestMethod.GET)
    public String userOrder(){
        return "user-order.html";
    }

}
