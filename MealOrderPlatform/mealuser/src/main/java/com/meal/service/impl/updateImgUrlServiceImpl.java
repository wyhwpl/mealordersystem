package com.meal.service.impl;

import com.meal.mapper.UserMapper;
import com.meal.pojo.User;
import com.meal.pojo.UserExample;
import com.meal.service.updateImgUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MealOrderPlatform
 * @Date: 2018/12/29 16:46
 * @Author: QiXiao
 * @Description:
 */
@Service
public class updateImgUrlServiceImpl implements updateImgUrlService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int storeImgUrl(String id, String path) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<User> users=userMapper.selectByExample(userExample);
        if(users==null||users.isEmpty()){
            return 0;
        }
        User user= users.get(0);
        user.setImgUrl(path);
        userMapper.updateByPrimaryKey(user);
        return 1;
    }
}
