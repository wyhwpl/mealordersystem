package com.meal.service;

/**
 * @program: MealOrderPlatform
 * @Date: 2019/1/3 15:20
 * @Author: QiXiao
 * @Description:
 */
public interface UploadImgService {
    int uploadSellerImg(String sellerid,String url);
    int uploadFoodImg(String foodid,String url);
}
