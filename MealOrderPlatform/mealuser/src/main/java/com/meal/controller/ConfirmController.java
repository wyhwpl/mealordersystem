package com.meal.controller;

import com.meal.service.ConfirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: MealOrderPlatform
 * @Date: 2018/12/30 18:30
 * @Author: QiXiao
 * @Description:
 */
@Controller
public class ConfirmController {
    @Autowired
    private ConfirmService confirmService;
    @RequestMapping(value="/confirm",method= RequestMethod.POST)
    @ResponseBody
    public int confirm(@RequestParam(value = "orderid")String id){
        return confirmService.confirm(id);
    }
    @RequestMapping(value="/evluate",method= RequestMethod.POST)
    @ResponseBody
    public int evluate(@RequestParam(value = "orderid")String id){
        return confirmService.evluate(id);
    }
}
