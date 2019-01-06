package com.meal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
@author 汪培林

@create 2018-12-02-19:11
*/
@Controller
public class IndexController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "seller-index";
    }
    @RequestMapping(value = "/seller-info",method = RequestMethod.GET)
    public String info(){
        return "seller-info";
    }
    @RequestMapping(value = "/shop-seller",method = RequestMethod.GET)
    public String shop(){
        return "shop-seller";
    }
}
