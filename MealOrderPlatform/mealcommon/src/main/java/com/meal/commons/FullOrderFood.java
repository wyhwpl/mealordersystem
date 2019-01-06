package com.meal.commons;

import com.meal.pojo.OrderFood;

/**
 * @program: MealOrderPlatform
 * @Date: 2018/12/30 15:30
 * @Author: QiXiao
 * @Description:
 */
public class FullOrderFood {
    private String foodname;
    private Float  foodprice;
    private OrderFood orderFood;

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public Float getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(Float foodprice) {
        this.foodprice = foodprice;
    }

    public OrderFood getOrderFood() {
        return orderFood;
    }

    public void setOrderFood(OrderFood orderFood) {
        this.orderFood = orderFood;
    }
}
