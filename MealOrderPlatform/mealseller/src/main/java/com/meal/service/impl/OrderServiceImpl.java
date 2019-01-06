package com.meal.service.impl;

import com.meal.commons.FullOrder;
import com.meal.commons.FullOrderFood;
import com.meal.commons.RiderCount;
import com.meal.commons.SaleNum;
import com.meal.mapper.*;
import com.meal.pojo.*;
import com.meal.service.OrderService;
import com.meal.util.CalculRider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
@author 汪培林

@create 2018-12-03-14:53
*/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RiderMapper riderMapper;

    @Autowired
    private SellerMapper sellerMapper;
    @Autowired
    private OrderFoodMapper orderFoodMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private OrderCancelMapper orderCancelMapper;

    public List<FullOrder> getAllOrder(String loginid) {

        SellerExample sellerExample=new SellerExample();
        SellerExample.Criteria criteria=sellerExample.createCriteria();
        criteria.andLoginidEqualTo(loginid);
        List<Seller> sellers=sellerMapper.selectByExample(sellerExample);
        if(sellers==null||sellers.isEmpty()){
            return null;
        }
        Seller seller=sellers.get(0);
        String sellerid=seller.getId();

        OrderExample example=new OrderExample();
        OrderExample.Criteria c=example.createCriteria();
        c.andSelleridEqualTo(sellerid);
        example.setOrderByClause("ordertime DESC");

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
            List<OrderFood> orderFoods = orderFoodMapper.selectByExample(orderFoodExample);
            List<FullOrderFood> fullOrderFoods=new ArrayList<FullOrderFood>();
            for(OrderFood o:orderFoods){
                FullOrderFood fullOrderFood=new FullOrderFood();
                String foodid=o.getFoodid();
                Food food = foodMapper.selectByPrimaryKey(foodid);
                fullOrderFood.setFoodname(food.getFoodname());

                fullOrderFood.setOrderFood(o);
                fullOrderFood.setFoodprice(food.getPrice());
                fullOrderFoods.add(fullOrderFood);
            }
            fullOrder.setOrderFoods(fullOrderFoods);
            fullOrders.add(fullOrder);

        }
        return fullOrders;
    }

    public List<Order> getOrderByExample(String sellerId, String param, int type) {
        OrderExample example=new OrderExample();
        OrderExample.Criteria criteria=example.createCriteria();
        criteria.andSelleridEqualTo(sellerId);

        //type=1、2代表订单Id、订单状态
        if(type==1){
            criteria.andIdEqualTo(param);
        }
        if(type==2){
            criteria.andStatusEqualTo(Integer.parseInt(param));
        }

        List<Order> orders=orderMapper.selectByExample(example);
        if(orders==null||orders.isEmpty()){
            return null;
        }
        return orders;
    }


    public int modifyOrderByExample(String orderId, String param, int type) {

        Order order=orderMapper.selectByPrimaryKey(orderId);

        //type=1 代表状态
        if(type==1){
            order.setStatus(Integer.parseInt(param));
        }


        return orderMapper.updateByPrimaryKey(order);
    }

    public int confirmOrder(String orderId, String sellerId) {

        return 0;
    }

    public int rejectOrder(String orderid) {
        Order order=orderMapper.selectByPrimaryKey(orderid);
        order.setStatus(-1);
        return orderMapper.updateByPrimaryKey(order);

    }

    public int acceptOrder(String orderid) {
        Order order=orderMapper.selectByPrimaryKey(orderid);
        order.setStatus(2);
        RiderExample riderExample=new RiderExample();
        RiderExample.Criteria criteria=riderExample.createCriteria();
        criteria.andStatusEqualTo(1);
        List<Rider> riders=riderMapper.selectByExample(riderExample);

        List<RiderCount> riderCounts=new ArrayList<RiderCount>();

        for (Rider r:riders) {
            Float f=r.getScore()*8;
            OrderCancelExample orderCancelExample=new OrderCancelExample();
            OrderCancelExample.Criteria occ=orderCancelExample.createCriteria();
            occ.andRideridEqualTo(r.getId());
            occ.andOrderidEqualTo(orderid);
            int num=orderCancelMapper.countByExample(orderCancelExample);
            f=f+num*(-3);
            OrderExample orderExample=new OrderExample();
            OrderExample.Criteria oc=orderExample.createCriteria();
            oc.andRideridEqualTo(r.getId());
            oc.andStatusEqualTo(3);
            int count=orderMapper.countByExample(orderExample);
            f=f+count*(-3);
            RiderCount riderCount=new RiderCount();
            riderCount.setId(r.getId());
            riderCount.setScore(f);
            riderCounts.add(riderCount);
        }
        if(riderCounts==null||riderCounts.isEmpty()){
            return 0;
        }
        String riderId= CalculRider.calculRider(riderCounts);
        Rider rider=riderMapper.selectByPrimaryKey(riderId);
        order.setRiderid(riderId);
        order.setRiderphone(rider.getPhone());
        return orderMapper.updateByPrimaryKey(order);


    }

    public List<SaleNum> getSaleNum(String phone) {

            SellerExample sellerExample=new SellerExample();
            SellerExample.Criteria sellerCriteria=sellerExample.createCriteria();
            sellerCriteria.andLoginidEqualTo(phone);
            List<Seller> sellers=sellerMapper.selectByExample(sellerExample);
            if(sellers.isEmpty()||sellers==null){
                return null;
            }
            String sellerId=sellers.get(0).getId();
            Date time=new Date();
            Calendar calendarI=Calendar.getInstance();
            calendarI.setTime(time);
            calendarI.add(Calendar.DAY_OF_MONTH,1);
            calendarI.set(Calendar.HOUR_OF_DAY,0);
            calendarI.set(Calendar.MINUTE,0);
            calendarI.set(Calendar.SECOND,0);
            Date after=calendarI.getTime();
            List<SaleNum> saleNums=new ArrayList<SaleNum>();
            for (int i = 0; i < 7; i++) {
                Calendar calendar=Calendar.getInstance();
                calendar.setTime(after);
                calendar.add(Calendar.DAY_OF_MONTH,-1);
                Date before=calendar.getTime();
                OrderExample orderExample=new OrderExample();
                OrderExample.Criteria orderCriteria=orderExample.createCriteria();
                orderCriteria.andSelleridEqualTo(sellerId);
                orderCriteria.andOrdertimeGreaterThan(before);
                orderCriteria.andOrdertimeLessThan(after);
                int count=orderMapper.countByExample(orderExample);
                SaleNum saleNum=new SaleNum();
                saleNum.setSales(count);
                saleNum.setTime(before);
                saleNums.add(saleNum);
                after=before;
            }
            return saleNums;


    }
}
