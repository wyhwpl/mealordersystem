package com.meal.service.impl;

import com.meal.commons.CreateUUID;
import com.meal.commons.FoodAndCopies;
import com.meal.mapper.*;
import com.meal.pojo.*;
import com.meal.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*
@author 汪培林

@create 2018-12-20-13:42
*/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SellerMapper sellerMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderFoodMapper orderFoodMapper;

    @Autowired
    private CartFoodMapper cartFoodMapper;

    @Autowired
    private CartMapper cartMapper;

    public int orderSubmit(String sellerId, String userId, String address, List<FoodAndCopies> list) {


            Order order = new Order();
            order.setId(CreateUUID.createUUID());

            order.setUserid(userId);
            User user=userMapper.selectByPrimaryKey(userId);
            order.setUsername(user.getUsername());
            order.setAddress(address);
            order.setPhone(user.getPhone());

            order.setSellerid(sellerId);
            Seller seller=sellerMapper.selectByPrimaryKey(sellerId);
            order.setSellername(seller.getSellername());
            order.setSellerphone(seller.getPhone());
            order.setSellersorce(seller.getScore());

            order.setStatus(1);

            order.setOrdertime(new Date());



            float price=0;
            for(int i = 0; i<list.size(); i++){
                OrderFood orderFood=new OrderFood();
                orderFood.setId(CreateUUID.createUUID());
                orderFood.setFoodid(list.get(i).getId());
                orderFood.setCopies(list.get(i).getAmount());


                price+=list.get(i).getPrice()*list.get(i).getAmount();
                orderFood.setPrice(price);

                orderFood.setOrderid(order.getId());
                orderFood.setScore(4.5f);
                orderFoodMapper.insert(orderFood);
            }
            order.setTotalPrice(price+5);
            return orderMapper.insert(order);



    }



}
