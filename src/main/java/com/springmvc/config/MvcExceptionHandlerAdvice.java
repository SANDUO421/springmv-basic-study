package com.springmvc.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义全局异常处理器
 * 
 * @author sanduo
 * @date 2018/05/21
 */
@ControllerAdvice // 声明一个控制器建言
public class MvcExceptionHandlerAdvice {

    @ExceptionHandler(value = Exception.class) // 过滤拦截的条件
    public ModelAndView exception(Exception exception, WebRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMessage", exception.getMessage());
        modelAndView.setViewName("error");// error 页面
        return modelAndView;

    }

    @ModelAttribute // 将键值对添加到全局@RequestMapping的注解可以获取次键值对
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息");
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");// 此处忽略参数id
    }

}
