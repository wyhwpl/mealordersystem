package com.meal.controller;

import com.meal.pojo.Seller;
import com.meal.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
@author 汪培林

@create 2018-12-19-15:01
*/
@Controller

public class SellerController {
    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = "/getshopinfo",method = RequestMethod.POST )
    @ResponseBody
    public Seller getSellerById(@RequestParam("sellerid") String sellerId){
        // System.out.println(sellerId);
        return sellerService.getSellerById(sellerId);
    }


    @RequestMapping(value = "/getByExample")
    @ResponseBody
    public List<Seller> getByExample(@RequestParam("province")String province,
                                     @RequestParam("city")String city,
                                     @RequestParam("district")String district,
                                     @RequestParam("street")String street){
        // System.out.println(city);
        String address=city+district;
        List list= sellerService.getSellerByExample(address);
        // System.out.println(list);
        return list;
    }
}
