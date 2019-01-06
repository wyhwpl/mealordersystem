package com.meal.service;

import com.meal.commons.CheckResult;
import com.meal.pojo.Address;
import com.meal.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/*
@author 汪培林

@create 2018-12-15-14:57
*/
public interface UserService {

    CheckResult loginCheck(HttpServletRequest request, HttpServletResponse response, User user);

    int logOff(String userId);
    User getUserInfo(String phone);
    int changePwd(String userId,String pwd);
    List<Address> getAddrs(String userid);
    int addnewAddr(String userid,String newaddr);
    int delAddr(String  addrid);
    int updateAddr(String addrid,String userid);
}
