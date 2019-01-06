package com.meal.controller;

import com.meal.commons.CheckResult;
import com.meal.pojo.Rider;
import com.meal.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
@author 汪培林

@create 2018-12-14-15:16
*/
@Controller
public class RiderController {

    @Autowired
    private RiderService riderService;

    @RequestMapping(value = "/rider-signin",method = RequestMethod.POST)
    @ResponseBody
    public CheckResult loginHandler(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @RequestParam("phone")String phone,
                                    @RequestParam("password")String password){
        Rider rider=new Rider();
        rider.setPhone(phone);
        rider.setPassword(password);
        return riderService.loginCheck(request,response,rider);
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginForm(){
        return "login-rider";
    }
    @RequestMapping(value = "/rider-index",method = RequestMethod.GET)
    public String index(){
        return "rider-index";
    }
    @RequestMapping(value = "/rider-info",method = RequestMethod.GET)
    public String info(){
        return "rider-info";
    }

    @RequestMapping(value = "/logOff")
    @ResponseBody
    public int logOff(@RequestParam("riderId") String riderId){
        return riderService.logOff(riderId);
    }

    @RequestMapping(value = "/applicationAgain",method = RequestMethod.POST)
    @ResponseBody
    public int application(@RequestParam("riderId")String riderId,
                           @RequestParam("userName")String userName,
                           @RequestParam("sex")String sex){
        Rider rider=new Rider();
        rider.setUsername(userName);
        rider.setSex(sex);
        return riderService.applicationAgain(riderId,rider);
    }

    @RequestMapping(value = "/modifyAddress")
    @ResponseBody
    public int modifyAddress(@RequestParam("riderId")String riderId,
                             @RequestParam("address")String address){
        return riderService.modifyAddress(riderId, address);
    }

    @RequestMapping(value = "/modifySex")
    @ResponseBody
    public int modifySex(@RequestParam("riderId")String riderId,
                             @RequestParam("sex")String sex){

        return riderService.modifySex(riderId, sex);
    }

    @RequestMapping(value = "/logout")
    public String logOut(HttpSession session){
        session.removeAttribute("rider");
        session.invalidate();
        return "login";
    }



}
