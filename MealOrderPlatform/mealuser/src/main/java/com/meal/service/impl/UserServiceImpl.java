package com.meal.service.impl;

import com.meal.commons.CheckResult;
import com.meal.commons.CreateUUID;
import com.meal.mapper.AddressMapper;
import com.meal.mapper.UserMapper;
import com.meal.pojo.Address;
import com.meal.pojo.AddressExample;
import com.meal.pojo.User;
import com.meal.pojo.UserExample;
import com.meal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/*
@author 汪培林

@create 2018-12-15-15:03
*/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;


    public CheckResult loginCheck(HttpServletRequest request, HttpServletResponse response, User user) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andPhoneEqualTo(user.getPhone());
        criteria.andPasswordEqualTo(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        List<User> users=userMapper.selectByExample(example);
        if(users==null||users.isEmpty()){
            return CheckResult.build(400,"账号或密码错误");
        }
        User userSession=users.get(0);
        userSession.setPassword(user.getPassword());
        request.getSession().setAttribute("user",userSession);
        return CheckResult.build(200,"登录成功");
    }

    public int logOff(String userId) {


        return userMapper.deleteByPrimaryKey(userId);
    }

    public User getUserInfo(String phone) {
        UserExample example=new UserExample();

        UserExample.Criteria criteria=example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<User> users=userMapper.selectByExample(example);
        if(users==null||users.isEmpty()){
            return null;
        }
        return users.get(0);
    }

    public int changePwd(String userId,String pwd) {
        User user=userMapper.selectByPrimaryKey(userId);

        user.setPassword(DigestUtils.md5DigestAsHex(pwd.getBytes()));

        return userMapper.updateByPrimaryKey(user);
    }

    public List<Address> getAddrs(String userid) {
        AddressExample addressExample=new AddressExample();
        AddressExample.Criteria criteria=addressExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<Address> list=addressMapper.selectByExample(addressExample);
        if(list==null||list.isEmpty()){
            return null;
        }
        return list;
    }

    public int addnewAddr(String userid, String newaddr) {
        Address address=new Address();
        address.setAddrid(CreateUUID.createUUID());
        address.setUserid(userid);
        address.setAddrdesc(newaddr);
        int insert = addressMapper.insert(address);
        return insert;
    }

    public int delAddr(String addrid) {

        int del=addressMapper.deleteByPrimaryKey(addrid);
        return del;
    }

    public int updateAddr(String addrid, String userid) {

        AddressExample addressExample=new AddressExample();
        AddressExample.Criteria criteria=addressExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<Address> list=addressMapper.selectByExample(addressExample);
        if(list==null||list.isEmpty()){
            return 0;
        }
        for(Address address:list){
            if(address.getAddrid().equals(addrid)){
                address.setRecentuse(1);
            }else{
                address.setRecentuse(0);
            }
            addressMapper.updateByPrimaryKey(address);
        }
        return 1;

    }


}
