package com.meal.commons;

import com.meal.pojo.Order;

import java.util.List;

/**
 * @program: MealOrderPlatform
 * @Date: 2018/12/30 15:13
 * @Author: QiXiao
 * @Description:
 */
public class FullOrder {
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean flag=false;
    private Order order;
    private List<FullOrderFood> orderFoods;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<FullOrderFood> getOrderFoods() {
        return orderFoods;
    }

    public void setOrderFoods(List<FullOrderFood> orderFoods) {
        this.orderFoods = orderFoods;
    }
}
