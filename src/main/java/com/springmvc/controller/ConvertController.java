package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.entity.User;

/**
 * 自定义转换的controller
 * 
 * @author sanduo
 * @date 2018/05/30
 */
@Controller
public class ConvertController {

    @RequestMapping(value = "/convert", produces = {"application/x-sanduo"}) // 自定返回的媒体类型为自定义的类型
    public @ResponseBody User convert(@RequestBody User user) {

        return user;
    }
}
