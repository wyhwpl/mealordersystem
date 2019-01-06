package com.meal.controller;

import com.meal.commons.FullOrder;
import com.meal.pojo.Order;
import com.meal.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@author 汪培林

@create 2018-12-14-15:59
*/
@Controller

public class OrderController {

    @Autowired
    private OrderService orderService;



    @RequestMapping(value = "/getorder",method = RequestMethod.POST)
    @ResponseBody
    public List<FullOrder> getOrderList(@RequestParam(value = "riderphone")String phone){

        List<FullOrder> allOrder = orderService.getAllOrder(phone);

        return allOrder;
    }
    @RequestMapping(value = "/rejectOrder",method = RequestMethod.POST)
    @ResponseBody
    public int reject(@RequestParam(value = "orderid")String orderid,
                      @RequestParam(value = "riderphone")String phone){

        return orderService.rejectOrder(orderid,phone);
    }
    @RequestMapping(value = "/acceptOrder",method = RequestMethod.POST)
    @ResponseBody
    public int accept(@RequestParam(value = "orderid")String orderid){

        return orderService.acceptOrder(orderid);
    }


    @RequestMapping(value = "/getDone")
    @ResponseBody
    public List<Order> getDone(@RequestParam("riderId")String riderId){
        return orderService.getDoneOrder(riderId);
    }

    @RequestMapping(value = "/getDoing")
    @ResponseBody
    public List<Order> getDoing(@RequestParam("riderId")String riderId){
        return orderService.getDoingOrder(riderId);
    }

    @RequestMapping(value = "/getToDo")
    @ResponseBody
    public List<Order> getToDo(@RequestParam("riderId")String riderId){
        return orderService.getToDoOrder(riderId);
    }

    @RequestMapping(value = "/modifyOrder/{flag}")
    @ResponseBody
    public int modifyOrder(@PathVariable boolean flag,
                           @RequestParam("orderId")String orderId){
        return orderService.cancelOrConfirmOrder(orderId, flag);
    }
}
