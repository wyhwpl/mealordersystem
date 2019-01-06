package com.meal.service;

import com.meal.commons.FullOrder;

import java.util.List;

/**
 * @program: MealOrderPlatform
 * @Date: 2018/12/30 14:28
 * @Author: QiXiao
 * @Description:
 */

public interface getOrderListService {
    List<FullOrder> getOrderList(String phone);
}
