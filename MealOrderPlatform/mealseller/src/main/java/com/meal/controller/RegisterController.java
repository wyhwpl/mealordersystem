package com.meal.controller;

/*
@author 汪培林

@create 2018-10-20-22:08
*/

import com.meal.commons.CheckResult;
import com.meal.pojo.Seller;
import com.meal.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/check/{param}/{type}")
    @ResponseBody
    public CheckResult registerCheck(@PathVariable String param,
                                     @PathVariable Integer type){

        return registerService.checkData(param, type);
    }
    @RequestMapping(value = "/regPage",method = RequestMethod.GET)
    public String registerForm(){

        return "register";
    }
    @RequestMapping(value = "/registerHandler",method = RequestMethod.POST)
    @ResponseBody
    public CheckResult register(@RequestBody Seller seller){

        /*seller.setIdcard();
        seller.setLoginid(loginId);
        seller.setSellername(sellerName);
        seller.setPassword(password);
        seller.setPhone(phone);
        seller.setName(name);
        seller.setAddress(address);*/
        System.out.println(seller.getLoginid());
        return registerService.register(seller);
    }

}
