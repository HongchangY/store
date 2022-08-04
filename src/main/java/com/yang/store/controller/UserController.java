package com.yang.store.controller;

import com.yang.store.pojo.User;
import com.yang.store.service.UserService;
import com.yang.store.utils.JsonResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    UserService userService;

    @RequestMapping("/reg")
    public JsonResults<Void> reg(User user){
        userService.register(user);
        // 如果没被controller基类捕获到异常则运行成功了
        return new JsonResults<>(OK);
    }


}
