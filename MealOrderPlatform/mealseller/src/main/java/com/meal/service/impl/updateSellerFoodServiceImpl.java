package com.meal.service.impl;

import com.meal.commons.CreateUUID;
import com.meal.mapper.*;
import com.meal.pojo.*;
import com.meal.service.updateSellerFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @program: MealOrderPlatform
 * @Date: 2019/1/3 16:25
 * @Author: QiXiao
 * @Description:
 */
@Service
public class updateSellerFoodServiceImpl implements updateSellerFoodService {
    @Autowired
    private ClassifyMapper classifyMapper;
    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private AdminTasksMapper adminTasksMapper;

    @Autowired
    private AdminNewsMapper adminNewsMapper;
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private SellerMapper sellerMapper;
    @Override
    public int addMenu(String sellerid, String menuname) {
        Classify classify=new Classify();
        classify.setId(CreateUUID.createUUID());
        classify.setSellerid(sellerid);
        System.out.println(menuname);
        classify.setClassifytag(menuname);
        return classifyMapper.insert(classify);
    }

    @Override
    public int delMenu(String menuid) {
       return classifyMapper.deleteByPrimaryKey(menuid);
    }

    @Override
    public int addFood(String sellerid, String tagid, String foodname, String desc, String price) {
        Date time=new Date();
        String id=CreateUUID.createUUID();
        Food food=new Food();
        food.setId(id);
        food.setSellerid(sellerid);
        food.setTagid(tagid);
        food.setFoodname(foodname);
        food.setDescription(desc);
        food.setPrice(Float.parseFloat(price));
        food.setApplicationtime(time);

        AdminTasks tasks=new AdminTasks();
        tasks.setId(CreateUUID.createUUID());
        tasks.setTaskkind(3);
        tasks.setObjectid(id);
        tasks.setUsername(food.getFoodname());
        tasks.setStatus(0);
        tasks.setTasktime(time);
        Random random=new Random();
        AdminExample example=new AdminExample();

        int count=adminMapper.countByExample(example);
        List<Admin> admins=adminMapper.selectByExample(example);

        int s=random.nextInt(count)%(count-1+1)+1;
        String adminId=admins.get(s-1).getId();
        System.out.println(adminId);
        tasks.setAdminid(adminId);
        int res=adminTasksMapper.insert(tasks);
        AdminNews news=new AdminNews();
        news.setId(CreateUUID.createUUID());
        news.setUserkind(1);
        news.setUserid(sellerid);
        news.setUsername(sellerMapper.selectByPrimaryKey(sellerid).getName());
        news.setAction("申请上架");
        news.setActionobject("菜品"+food.getFoodname());
        news.setNewstime(time);
        adminNewsMapper.insert(news);
        return foodMapper.insert(food);
    }

    @Override
    public int updateFoodInfo(String foodid, String foodname, String desc, String price) {
        Food food = foodMapper.selectByPrimaryKey(foodid);
        food.setFoodname(foodname);
        food.setDescription(desc);
        food.setPrice(Float.parseFloat(price));
        return foodMapper.updateByPrimaryKey(food);
    }

    @Override
    public int delFood(String foodid) {
        return foodMapper.deleteByPrimaryKey(foodid);
    }
}
