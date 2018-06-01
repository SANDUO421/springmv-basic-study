package com.springmvc.utils;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import com.springmvc.entity.User;

/**
 * 自定义MessageConvert
 * 
 * @author sanduo
 * @date 2018/05/30
 */
public class MyMessageConvert extends AbstractHttpMessageConverter<User> {

    /**
     * 构造
     */
    public MyMessageConvert() {
        // 自定义一个媒体类型
        super(new MediaType("application", "x-sanduo", Charset.forName("UTF-8")));

    }

    /* 处理请求数据
     * @see org.springframework.http.converter.AbstractHttpMessageConverter#readInternal(java.lang.Class, org.springframework.http.HttpInputMessage)
     */
    @Override
    protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage)
        throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        return new User(new Long(tempArr[0]), tempArr[1]);
    }

    /* 支持处理User类
     * @see org.springframework.http.converter.AbstractHttpMessageConverter#supports(java.lang.Class)
     */
    @Override
    protected boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    /* 处理输出数据到response
     * @see org.springframework.http.converter.AbstractHttpMessageConverter#writeInternal(java.lang.Object, org.springframework.http.HttpOutputMessage)
     */
    @Override
    protected void writeInternal(User user, HttpOutputMessage outputMessage)
        throws IOException, HttpMessageNotWritableException {
        String out = "hello:" + user.getId() + "-" + user.getName();
        outputMessage.getBody().write(out.getBytes());
        // outputMessage.getBody().close();
    }

}
