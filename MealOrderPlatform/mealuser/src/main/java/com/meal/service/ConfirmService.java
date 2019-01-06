package com.meal.service;

/**
 * @program: MealOrderPlatform
 * @Date: 2018/12/30 18:33
 * @Author: QiXiao
 * @Description:
 */
public interface ConfirmService {
    int confirm(String orderid);
    int evluate(String orderid);
}
