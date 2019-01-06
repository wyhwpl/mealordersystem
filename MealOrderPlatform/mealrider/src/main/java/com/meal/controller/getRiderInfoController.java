package com.meal.controller;

import com.meal.mapper.RiderMapper;
import com.meal.pojo.Rider;
import com.meal.pojo.RiderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: MealOrderPlatform
 * @Date: 2019/1/3 21:59
 * @Author: QiXiao
 * @Description:
 */
@Controller
public class getRiderInfoController {
    @Autowired
    private RiderMapper riderMapper;
    @RequestMapping(value = "/rider-info",method = RequestMethod.POST)
    @ResponseBody
    public Rider getInfo(@RequestParam(value = "phone")String phone){
        RiderExample riderExample=new RiderExample();
        RiderExample.Criteria c=riderExample.createCriteria();
        c.andPhoneEqualTo(phone);
        List<Rider> riders = riderMapper.selectByExample(riderExample);
        if(riders==null||riders.isEmpty()){
            return null;
        }
        return riders.get(0);
    }
}
