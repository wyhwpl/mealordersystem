package com.meal.controller;

import com.meal.commons.FullOrder;
import com.meal.service.getOrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: MealOrderPlatform
 * @Date: 2018/12/30 14:41
 * @Author: QiXiao
 * @Description:
 */
@Controller
public class getOrderListController {
    @Autowired
    private getOrderListService getOrderListService;
    @RequestMapping(value = "/getorderlist",method= RequestMethod.POST)
    @ResponseBody
    public List<FullOrder> getOrderlist(@RequestParam(value="phone")String phone){
        return getOrderListService.getOrderList(phone);
    }
}
