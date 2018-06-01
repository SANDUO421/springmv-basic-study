package com.springmvc.config;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.springmvc.utils.MyMessageConvert;

/**
 * mvc 的配置 ; 继承WebMvcConfigurerAdapter实现自定义配置;
 * 
 * @author sanduo
 * @date 2018/05/18
 */
@Configuration
@EnableScheduling // 开启定时任务
@WebServlet(asyncSupported = true) // 开启servlet异步支持
@EnableAsync
@EnableWebMvc // 导入spring MVC的配置
@ComponentScan(
    value = {"com.springmvc.controller", "com.springmvc.config", "com.springmvc.utils", "com.springmvc.service"})
public class MvcConfig extends WebMvcConfigurerAdapter {
    /*
     * 配置拦截器Bean
     */
    @Bean
    public MvcInterceptor mvcInterceptor() {
        return new MvcInterceptor();
    }

    /**
     * 创建视图解析器类
     * 
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // 注意此处是运行时的路径
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;

    }

    /**
     * 文件上传
     * 
     * @return
     */
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("UTF-8");
        commonsMultipartResolver.setMaxUploadSize(1073741824);// 设置文件上传大小
        return commonsMultipartResolver;
    }

    @Bean
    public MyMessageConvert convert() {
        return new MyMessageConvert();
    }

    /* 自定义静态资源映射（js，css，图片）
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry)
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // super.addResourceHandlers(registry);
        // addResourceLocations:文件存放的目录；addResourceHandler:对外暴露的访问路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /* 注册自定义拦截器
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mvcInterceptor());
    }

    /* 处理页面转向；文件上传
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry)
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");// 首页
        registry.addViewController("/toUpload").setViewName("upload");// 文件上传
        registry.addViewController("/converter").setViewName("/converter");// 转换
        registry.addViewController("/sse").setViewName("/sse");// sse浏览器服务推送
        registry.addViewController("/async").setViewName("/async");// servlet浏览器服务推送
    }

    /* 防止路径中有"."等特殊符号被忽略
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configurePathMatch(org.springframework.web.servlet.config.annotation.PathMatchConfigurer)
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    /* 添加自定义的convert,不覆盖
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#extendMessageConverters(java.util.List)
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // super.extendMessageConverters(converters);
        converters.add(convert());
    }

    /* 开启静态资源的请求转发到默认servlet上，不配置页面404
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureDefaultServletHandling(org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer)
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
