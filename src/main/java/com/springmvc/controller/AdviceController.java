package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.entity.User;

/**
 * 全局控制器controller的演示
 * 
 * @author sanduo
 * @date 2018/05/21
 */
@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, User user) {
        throw new IllegalArgumentException("非常抱歉,参数有误/" + "来自@ModelAttribute：" + msg);
        // return msg;

    }
}
