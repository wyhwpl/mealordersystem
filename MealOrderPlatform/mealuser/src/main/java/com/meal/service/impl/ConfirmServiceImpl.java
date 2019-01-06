package com.meal.service.impl;

import com.meal.mapper.OrderMapper;
import com.meal.pojo.Order;
import com.meal.service.ConfirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: MealOrderPlatform
 * @Date: 2018/12/30 18:34
 * @Author: QiXiao
 * @Description:
 */
@Service
public class ConfirmServiceImpl implements ConfirmService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public int confirm(String orderid) {
        Order order =orderMapper.selectByPrimaryKey(orderid);
        order.setStatus(5);
        return orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public int evluate(String orderid) {
        Order order =orderMapper.selectByPrimaryKey(orderid);
        order.setStatus(6);
        return orderMapper.updateByPrimaryKey(order);
    }
}
