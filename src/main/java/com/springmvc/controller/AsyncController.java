package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.springmvc.service.PushService;

/**
 * servlet 3.0 异步推送
 * 
 * @author sanduo
 * @date 2018/05/31
 */
@Controller
public class AsyncController {

    // @Resource(name = "pushService")
    @Autowired
    private PushService pushService;

    @RequestMapping(value = "/defer")
    @ResponseBody
    @Async // 标记方法作为异步执行
    public DeferredResult<String> deferredCall() {
        // FIXME 此处处理异步有问题,结果似乎是对的
        return pushService.getAsyncUpdate();
    }

}
