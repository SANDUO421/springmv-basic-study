package com.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.entity.User;

/**
 * restController
 * 
 * @author sanduo
 * @date 2018/05/21
 */
@RestController
@RequestMapping("/user/rest")
public class UserRestController {

    @RequestMapping(value = "/getjson", produces = "application/json;charset=UTF-8")
    public User getJson(User user) {

        return new User(user.getId(), user.getName() + " yy");
    }

    @RequestMapping(value = "/getxml", produces = "application/xml;charset=UTF-8")
    public User getXml(User user) {

        return new User(user.getId() + 1, user.getName() + "yy");
    }
}
