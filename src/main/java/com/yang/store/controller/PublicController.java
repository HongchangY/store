package com.yang.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicController extends BaseController{

    /** 网站首页 */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    /** 登录页面*/
    @RequestMapping("/login")
    public String login(){
        return "/web/login";
    }

    /** 注册 */
    @RequestMapping("/reg")
    public String reg(){
        return "/web/register";
    }

    /** 404 */
    @RequestMapping("/error400")
    public String error400(){
        return "/web/404";
    }

    /** 500 */
    @RequestMapping("/error500")
    public String error500(){
        return "/web/500";
    }

}
