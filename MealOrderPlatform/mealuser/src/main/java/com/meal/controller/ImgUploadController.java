package com.meal.controller;

import com.meal.service.updateImgUrlService;
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
 * @Date: 2018/12/29 16:08
 * @Author: QiXiao
 * @Description:
 */
@Controller
public class ImgUploadController {
    @Autowired
    private updateImgUrlService updateImgUrlService;
    @RequestMapping(value="/uploadimg",method = RequestMethod.POST)
    @ResponseBody
    public int uploadimg(@RequestParam(value = "file") MultipartFile file,
                         @RequestParam(value="id")String id){
        // System.out.println(file);
        // System.out.println(id);
        if (file==null || file.isEmpty()) {
            // logger.error("文件为空");
            return 0;
        }else {

            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get("E:\\files\\softwareProject\\MealOrderPlatFormPro-master\\MealOrderPlatform\\mealuser\\src\\main\\webapp\\WEB-INF\\jsp\\static\\"+file.getOriginalFilename());
                String imgUrl="static/"+file.getOriginalFilename();
                updateImgUrlService.storeImgUrl(id,imgUrl);
                //如果没有files文件夹，则创建
                /*
                if (!Files.isWritable(path)) {
                    Files.createDirectories(Paths.get(UPLOAD_FOLDER));
                }
                */
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
