package com.meal.service;

/**
 * @program: MealOrderPlatform
 * @Date: 2019/1/3 16:14
 * @Author: QiXiao
 * @Description:
 */
public interface updateSellerFoodService {
    int addMenu(String sellerid,String menuname);
    int delMenu(String menuid);
    int addFood(String sellerid,String tagid,String foodname,String desc,String price);
    int updateFoodInfo(String foodid,String foodname,String desc,String price);
    int delFood(String foodid);
}
