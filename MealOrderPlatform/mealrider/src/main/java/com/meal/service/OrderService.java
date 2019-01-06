package com.meal.service;

import com.meal.commons.FullOrder;
import com.meal.pojo.Order;

import java.util.List;

/*
@author 汪培林

@create 2018-12-13-15:21
*/
public interface OrderService {

//    List<Order> getAllOrder(String riderId);
    List<FullOrder> getAllOrder(String sellerId);

    List<Order> getDoneOrder(String riderId);

    List<Order> getDoingOrder(String riderId);

    List<Order> getToDoOrder(String riderId);

    int cancelOrConfirmOrder(String orderId,boolean flag);
    int rejectOrder(String orderid,String phone);
    int acceptOrder(String orderid);
}
