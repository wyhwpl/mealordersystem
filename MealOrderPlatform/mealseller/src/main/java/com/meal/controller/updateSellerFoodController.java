package com.meal.controller;

import com.meal.service.updateSellerFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: MealOrderPlatform
 * @Date: 2019/1/3 16:40
 * @Author: QiXiao
 * @Description:
 */
@Controller
public class updateSellerFoodController {
    @Autowired
    private updateSellerFoodService updateSellerFoodService;

    @RequestMapping(value = "/addmenu",method = RequestMethod.POST)
    @ResponseBody
    public int addMenu(@RequestParam(value = "sellerid")String sellerid,
                       @RequestParam(value = "menuname")String menuname){

        System.out.println(menuname);
        return updateSellerFoodService.addMenu(sellerid,menuname);
    }
    @RequestMapping(value = "/addfood",method = RequestMethod.POST)
    @ResponseBody
    public int addFood(@RequestParam(value = "sellerid")String sellerid,
                       @RequestParam(value = "tagid")String tagid,
                       @RequestParam(value = "foodname")String foodname,
                       @RequestParam(value = "fooddesc")String fooddesc,
                       @RequestParam(value = "foodprice")String foodprice){
        return updateSellerFoodService.addFood(sellerid,tagid,foodname,fooddesc,foodprice);
    }
    @RequestMapping(value = "/updatefood",method = RequestMethod.POST)
    @ResponseBody
    public int updateFood(@RequestParam(value = "foodid")String foodid,
                          @RequestParam(value = "foodname")String foodname,
                          @RequestParam(value = "fooddesc")String fooddesc,
                          @RequestParam(value = "foodprice")String foodprice){
        return updateSellerFoodService.updateFoodInfo(foodid,foodname,fooddesc,foodprice);
    }
    @RequestMapping(value = "/delfood",method = RequestMethod.POST)
    @ResponseBody
    public int delFood(@RequestParam(value = "foodid")String foodid){
        return updateSellerFoodService.delFood(foodid);
    }
    @RequestMapping(value = "/delmenu",method = RequestMethod.POST)
    @ResponseBody
    public int delMenu(@RequestParam(value = "menuid")String menuid){
        return updateSellerFoodService.delMenu(menuid);
    }
}
