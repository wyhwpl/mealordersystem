package com.meal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
@author 汪培林

@create 2018-12-15-18:26
*/
@Controller
public class UserIndexController {

    @RequestMapping(value = "/user-index",method= RequestMethod.GET)
    public String userIndex(){
        return "user-index.html";
    }
}
