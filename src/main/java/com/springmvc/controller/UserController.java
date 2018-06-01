package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.entity.User;

/**
 * controller
 * 
 * @author sanduo
 * @date 2018/05/18
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * produces 定制返回的
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/index", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request) {

        return "url:" + request.getRequestURL() + "can accress";
    }

    @RequestMapping(value = "/path/{str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String pathVar(@PathVariable String str, HttpServletRequest request) {

        return "url:" + request.getRequestURL() + "can accress,str=" + str;
    }

    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id, HttpServletRequest request) {

        return "url:" + request.getRequestURL() + "can accress,id=" + id;
    }

    @RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String passObj(User user, HttpServletRequest request) {

        return "url:" + request.getRequestURL() + "can accress,obj id:" + user.getId() + ",obj Name:" + user.getName();
    }

    @RequestMapping(value = {"/name1", "/name2"}, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request) {

        return "url:" + request.getRequestURL() + ",can accress";
    }
}
