package com.meal.service;

import com.meal.commons.FoodAndCopies;

import java.util.List;

/*
@author 汪培林

@create 2018-12-20-13:40
*/
public interface OrderService {

    int orderSubmit(String sellerId, String userId, String address, List<FoodAndCopies> list);
}
