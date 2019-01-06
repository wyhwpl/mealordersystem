package com.meal.controller;

import com.meal.service.UploadImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @program: MealOrderPlatform
 * @Date: 2019/1/3 14:36
 * @Author: QiXiao
 * @Description:
 */
@Controller
public class UpImgController {
    @Autowired
    private UploadImgService uploadImgService;
    @RequestMapping(value="/upsellerimg",method = RequestMethod.POST)
    @ResponseBody
    public int uploadsellerimg(@RequestParam(value = "file") MultipartFile file,
                         @RequestParam(value="sellerid")String sellerid){

        // System.out.println(id);
        if (file==null || file.isEmpty()) {
            return 0;
        }else {
            try {
                byte[] bytes = file.getBytes();

                Path path = Paths.get("D:\\work\\Vue\\MealOrderPlatFormPro-master\\MealOrderPlatFormPro-master\\MealOrderPlatform\\mealseller\\src\\main\\webapp\\WEB-INF\\jsp\\static\\"+file.getOriginalFilename());
                String imgUrl="static/"+file.getOriginalFilename();
                uploadImgService.uploadSellerImg(sellerid,imgUrl);

                //文件写入指定路径
                Files.write(path, bytes);

                return 1;
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }


        }
    }
    @RequestMapping(value="/upfoodimg",method = RequestMethod.POST)
    @ResponseBody
    public int uploadimg(@RequestParam(value = "file") MultipartFile file,
                         @RequestParam(value="foodid")String foodid){

        if (file==null || file.isEmpty()) {

            return 0;
        }else {

            try {
                byte[] bytes = file.getBytes();

                Path path = Paths.get("D:\\work\\Vue\\MealOrderPlatFormPro-master\\MealOrderPlatFormPro-master\\MealOrderPlatform\\mealseller\\src\\main\\webapp\\WEB-INF\\jsp\\static\\"+file.getOriginalFilename());
                String imgUrl="static/"+file.getOriginalFilename();
                uploadImgService.uploadFoodImg(foodid,imgUrl);
                //文件写入指定路径
                Files.write(path, bytes);

                return 1;
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }


        }
    }
}
