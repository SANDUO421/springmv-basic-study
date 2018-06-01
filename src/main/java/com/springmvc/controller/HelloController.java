package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sanduo
 * @date 2018/05/18
 */
// @RestController // 注明一个控制器
@Controller
public class HelloController {

    @RequestMapping("/index") // 配置URL和方法之间的映射
    public String hello() {
        // 说明页面在/WEB-INF/classes/views/index.jsp
        return "index";
    }
}
