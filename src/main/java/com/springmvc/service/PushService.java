package com.springmvc.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author sanduo
 * @date 2018/05/31
 */
// @Service("pushService")
@Service
public class PushService {

    private DeferredResult<String> deferredResult;

    /**
     * 产生的给控制器使用
     * 
     * @return
     */
    public DeferredResult<String> getAsyncUpdate() {
        deferredResult = new DeferredResult<String>();
        return deferredResult;
    }

    /**
     * 定时刷新deferredResult
     */
    @Scheduled(fixedDelay = 5000)
    public void refresh() {
        if (deferredResult != null) {
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }

}
