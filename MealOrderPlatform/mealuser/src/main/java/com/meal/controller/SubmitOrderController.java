package com.meal.controller;

import com.meal.commons.FoodAndCopies;
import com.meal.service.OrderService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: MealOrderPlatform
 * @Date: 2018/12/31 19:42
 * @Author: QiXiao
 * @Description:
 */
@Controller
public class SubmitOrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/submitorder",method = RequestMethod.POST)
    @ResponseBody
    public int submitOrder(@RequestParam(value = "userid")String userid,
                           @RequestParam(value = "sellerid")String sellerid,
                           @RequestParam(value = "addr")String addr,
                           @RequestParam(value = "foods")String foods){
        // System.out.println(userid);
        // System.out.println(foods);
        JSONArray list=JSONArray.fromObject(foods);
        List<FoodAndCopies> foodlist=JSONArray.toList(list,new FoodAndCopies(),new JsonConfig());
        /*if(foodlist!=null){
            System.out.println(foodlist.size());
        }*/


        return orderService.orderSubmit(sellerid,userid,addr,foodlist);
    }
}
