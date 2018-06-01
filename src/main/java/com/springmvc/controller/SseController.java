package com.springmvc.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * SSE：实现服务端推送 注意返回值：必须是UTF-8
 * 
 * @author sanduo
 * @date 2018/05/31
 */
@Controller
public class SseController {

    @RequestMapping(value = "/push", produces = "text/event-stream;charset=UTF-8") // 服务器SSE支持,注意返回值类型
    public @ResponseBody String push() {
        Random random = new Random();
        try {
            Thread.sleep(5000);// 等待5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Test 1,2,3" + random.nextInt() + "\n\n";
    }

}
