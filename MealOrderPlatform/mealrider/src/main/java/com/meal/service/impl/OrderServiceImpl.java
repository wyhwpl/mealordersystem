package com.meal.service.impl;

import com.meal.commons.CreateUUID;
import com.meal.commons.FullOrder;
import com.meal.commons.FullOrderFood;
import com.meal.mapper.*;
import com.meal.pojo.*;
import com.meal.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
@author 汪培林

@create 2018-12-13-15:55
*/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderCancelMapper orderCancelMapper;
    @Autowired
    private OrderFoodMapper orderFoodMapper;
    @Autowired
    private RiderMapper riderMapper;
    @Autowired
    private FoodMapper foodMapper;




    public List<Order> getDoneOrder(String riderId) {
        OrderExample example=new OrderExample();
        OrderExample.Criteria criteria=example.createCriteria();
        criteria.andRideridEqualTo(riderId);
        List<Integer> status=new ArrayList<Integer>();
        status.add(4);
        status.add(5);
        status.add(6);
        criteria.andStatusIn(status);
        List<Order> orders=orderMapper.selectByExample(example);
        if(orders==null||orders.isEmpty()){
            return null;
        }
        return orders;
    }

    public List<Order> getDoingOrder(String riderId) {
        OrderExample example=new OrderExample();
        OrderExample.Criteria criteria=example.createCriteria();
        criteria.andRideridEqualTo(riderId);
        criteria.andStatusEqualTo(3);
        List<Order> orders=orderMapper.selectByExample(example);
        if(orders==null||orders.isEmpty()){
            return null;
        }
        return orders;
    }

    public List<Order> getToDoOrder(String riderId) {
        OrderExample example=new OrderExample();
        OrderExample.Criteria criteria=example.createCriteria();
        criteria.andStatusEqualTo(2);
        criteria.andRideridEqualTo(riderId);
        List<Order> orders=orderMapper.selectByExample(example);
        if(orders==null||orders.isEmpty()){
            return null;
        }
        return orders;
    }

    public int cancelOrConfirmOrder(String orderId, boolean flag) {

        Order order=orderMapper.selectByPrimaryKey(orderId);
        if(order==null){
            return 0;
        }
        if(flag){
            order.setStatus(3);

        }
        else{
            order.setStatus(2);
            order.setRiderid(null);
            order.setRiderphone(null);
            OrderCancel cancel=new OrderCancel();
            cancel.setOrderid(orderId);
            cancel.setRiderid(order.getRiderid());
            orderCancelMapper.insert(cancel);
        }

        int result=orderMapper.updateByPrimaryKey(order);
        return result;
    }
    public List<FullOrder> getAllOrder(String phone) {

        RiderExample riderExample=new RiderExample();
        RiderExample.Criteria criteria=riderExample.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<Rider> riders = riderMapper.selectByExample(riderExample);
        if(riders==null||riders.isEmpty()){

            return null;
        }
        Rider rider=riders.get(0);
        String riderid=rider.getId();

        OrderExample example=new OrderExample();
        OrderExample.Criteria c=example.createCriteria();
        example.setOrderByClause("ordertime DESC");
        c.andRideridEqualTo(riderid);

        List<Order> orders = orderMapper.selectByExample(example);
        if(orders==null||orders.isEmpty()){
            return null;
        }
        List<FullOrder> fullOrders=new ArrayList<FullOrder>();

        for(Order order:orders){
            FullOrder fullOrder=new FullOrder();

            fullOrder.setOrder(order);
            String orderid=order.getId();

            OrderFoodExample orderFoodExample=new OrderFoodExample();
            OrderFoodExample.Criteria criteria1=orderFoodExample.createCriteria();
            criteria1.andOrderidEqualTo(orderid);
            int j=0;
            List<OrderFood> orderFoods = orderFoodMapper.selectByExample(orderFoodExample);
            List<FullOrderFood> fullOrderFoods=new ArrayList<FullOrderFood>();
            for(OrderFood o:orderFoods){
                FullOrderFood fullOrderFood=new FullOrderFood();
                String foodid=o.getFoodid();
                Food food = foodMapper.selectByPrimaryKey(foodid);
                fullOrderFood.setOrderFood(o);
                fullOrderFood.setFoodname(food.getFoodname());
                fullOrderFood.setFoodprice(food.getPrice());
                fullOrderFoods.add(fullOrderFood);
            }
            fullOrder.setOrderFoods(fullOrderFoods);
            fullOrders.add(fullOrder);

        }
        return fullOrders;
    }
    public int rejectOrder(String orderid,String phone) {

        RiderExample riderExample=new RiderExample();
        RiderExample.Criteria criteria=riderExample.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<Rider> riders = riderMapper.selectByExample(riderExample);
        if(riders==null||riders.isEmpty()){
            return 0;
        }
        Rider rider=riders.get(0);
        String riderid=rider.getId();
        Order order=orderMapper.selectByPrimaryKey(orderid);
        order.setStatus(2);
        order.setRiderid(null);
        order.setRiderphone(null);
        OrderCancel orderCancel=new OrderCancel();
        orderCancel.setId(CreateUUID.createUUID());
        orderCancel.setOrderid(orderid);
        orderCancel.setRiderid(riderid);
        orderCancelMapper.insert(orderCancel);
        return orderMapper.updateByPrimaryKey(order);

    }

    public int acceptOrder(String orderid) {
        Order order=orderMapper.selectByPrimaryKey(orderid);
        order.setStatus(3);
        OrderCancelExample ocExample=new OrderCancelExample();
        OrderCancelExample.Criteria criteria=ocExample.createCriteria();
        criteria.andOrderidEqualTo(orderid);
        orderCancelMapper.deleteByExample(ocExample);
        return orderMapper.updateByPrimaryKey(order);
    }
}
