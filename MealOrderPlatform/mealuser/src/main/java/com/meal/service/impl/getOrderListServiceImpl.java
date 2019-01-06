package com.meal.service.impl;

import com.meal.commons.FullOrder;
import com.meal.commons.FullOrderFood;
import com.meal.mapper.FoodMapper;
import com.meal.mapper.OrderFoodMapper;
import com.meal.mapper.OrderMapper;
import com.meal.mapper.UserMapper;
import com.meal.pojo.*;
import com.meal.service.getOrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MealOrderPlatform
 * @Date: 2018/12/30 14:30
 * @Author: QiXiao
 * @Description:
 */
@Service
public class getOrderListServiceImpl implements getOrderListService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderFoodMapper orderFoodMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Override
    public List<FullOrder> getOrderList(String phone) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<User> users = userMapper.selectByExample(example);
        if(users==null||users.isEmpty()){
            return null;
        }
        User user=users.get(0);
        String id=user.getId();
        OrderExample orderExample=new OrderExample();
        OrderExample.Criteria c=orderExample.createCriteria();
        orderExample.setOrderByClause("ordertime DESC");
        c.andUseridEqualTo(id);
        List<Order> orders = orderMapper.selectByExample(orderExample);
        if(users==null||users.isEmpty()){
            return null;
        }
        List<FullOrder> fullOrders=new ArrayList<>();

        for(Order order:orders){
            FullOrder fullOrder=new FullOrder();
            fullOrder.setOrder(order);
            String orderid=order.getId();


            OrderFoodExample orderFoodExample=new OrderFoodExample();
            OrderFoodExample.Criteria criteria1=orderFoodExample.createCriteria();
            criteria1.andOrderidEqualTo(orderid);
            List<OrderFood> orderFoods = orderFoodMapper.selectByExample(orderFoodExample);
            List<FullOrderFood> fullOrderFoods=new ArrayList<>();
            for(OrderFood o:orderFoods){
                FullOrderFood fullOrderFood=new FullOrderFood();
                String foodid=o.getFoodid();
                Food food = foodMapper.selectByPrimaryKey(foodid);
                fullOrderFood.setFoodname(food.getFoodname());
                fullOrderFood.setFoodprice(food.getPrice());
                fullOrderFood.setOrderFood(o);
                fullOrderFoods.add(fullOrderFood);
            }
            fullOrder.setOrderFoods(fullOrderFoods);
            fullOrders.add(fullOrder);

        }
        return fullOrders;



    }
}
