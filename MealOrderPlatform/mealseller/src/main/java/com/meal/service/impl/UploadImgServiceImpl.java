package com.meal.service.impl;

import com.meal.mapper.FoodMapper;
import com.meal.mapper.SellerMapper;
import com.meal.pojo.Food;
import com.meal.pojo.Seller;
import com.meal.service.UploadImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: MealOrderPlatform
 * @Date: 2019/1/3 15:21
 * @Author: QiXiao
 * @Description:
 */
@Service
public class UploadImgServiceImpl implements UploadImgService {
    @Autowired
    private SellerMapper sellerMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Override
    public int uploadSellerImg(String sellerid, String url) {
        Seller seller=sellerMapper.selectByPrimaryKey(sellerid);
        seller.setImgUrl(url);
        return sellerMapper.updateByPrimaryKey(seller);

    }

    @Override
    public int uploadFoodImg(String foodid, String url) {
        Food food =foodMapper.selectByPrimaryKey(foodid);
        food.setImgUrl(url);
        return foodMapper.updateByPrimaryKey(food);
    }
}
