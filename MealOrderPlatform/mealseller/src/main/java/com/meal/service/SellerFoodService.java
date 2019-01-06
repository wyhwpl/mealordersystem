package com.meal.service;

import com.meal.commons.SellerFood;

/**
 * @program: MealOrderPlatform
 * @Date: 2019/1/2 19:32
 * @Author: QiXiao
 * @Description:
 */
public interface SellerFoodService {
    SellerFood getSellerFood(String sellerId);
}
