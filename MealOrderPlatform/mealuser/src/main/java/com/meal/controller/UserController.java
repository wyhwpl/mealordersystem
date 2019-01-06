package com.meal.controller;

import com.meal.commons.CheckResult;
import com.meal.pojo.Address;
import com.meal.pojo.User;
import com.meal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/*
@author 汪培林

@create 2018-12-15-15:12
*/
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginForm(){
        // System.out.println("success");
        return "login-user.html";
    }


    @RequestMapping(value = "/login-user",method = RequestMethod.POST)
    @ResponseBody
    public CheckResult loginHandler(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @RequestParam(value = "phone")String phone,
                                    @RequestParam(value = "password")String password){
        // System.out.println(phone+password);

        User user=new User();
        user.setPhone(phone);
        user.setPassword(password);
        return userService.loginCheck(request,response,user);
    }

    @RequestMapping(value = "/logOff")
    @ResponseBody
    public int logOff(@RequestParam("userId")String  userId){
        return userService.logOff(userId);
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        return "user-index.html";
    }
    @RequestMapping(value="/user-info",method=RequestMethod.POST)
    @ResponseBody
    public User getUserInfo(@RequestParam(value="phone") String phone){

        return userService.getUserInfo(phone);

    }
    @RequestMapping(value="/changepwd",method=RequestMethod.POST)
    @ResponseBody
    public int changepwd(@RequestParam(value="userId")String id,
                         @RequestParam(value="newPwd")String pwd){
        return userService.changePwd(id,pwd);
    }
    @RequestMapping(value="/getAddrs", method=RequestMethod.POST)
    @ResponseBody
    public List<Address> getAddrs(@RequestParam(value="userId")String id){

        return userService.getAddrs(id);
    }
    @RequestMapping(value="/addnewAddr", method=RequestMethod.POST)
    @ResponseBody
    public int addnewAddr(@RequestParam(value="userid")String id,
                          @RequestParam(value="newaddr")String addr){

        return userService.addnewAddr(id,addr);
    }
    @RequestMapping(value="/deladdr",method=RequestMethod.POST)
    @ResponseBody
    public int deladdr(@RequestParam(value="addrid")String addrid){
        return userService.delAddr(addrid);
    }
    @RequestMapping(value="/bedefaultaddr",method = RequestMethod.POST)
    @ResponseBody
    public int changeDefaultAddr(@RequestParam(value = "addrid")String addrid,
                                 @RequestParam(value="userid")String userid){
        return userService.updateAddr(addrid,userid);
    }
    @RequestMapping(value="/shop.html",method=RequestMethod.GET)

    public String toshop(){
        return "shop.html";
    }

}
