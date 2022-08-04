package com.yang.store.controller;


import com.yang.store.service.ex.InsertException;
import com.yang.store.service.ex.ServiceException;
import com.yang.store.service.ex.UsernameDupulicatedException;
import com.yang.store.utils.JsonResults;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {

    public static final Integer OK = 200;

    @ExceptionHandler(ServiceException.class)
    public JsonResults<Void> HandlerException(Throwable e){
        JsonResults<Void> result = new JsonResults<>();
        if(e instanceof UsernameDupulicatedException){
            result.setMessage("用户名已存在");
            result.setStatus(3000);
        }else if(e instanceof InsertException){
            result.setMessage("注册期间产生未知错误");
            result.setStatus(4000);
        }
//        返回异常产生的原因和状态码回产生异常的前端页面
        return result;
    }

}
