package com.springmvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.springmvc.config.MvcConfig;
import com.springmvc.service.DemoService;

/**
 * 集成测试-service测试
 * 
 * @author sanduo
 * @date 2018/06/01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class})
@WebAppConfiguration(value = "src/main/resources") // 声明加载ApplicationContext 是一个WebApplicationContext-指定资源的位置
public class TestControllerIntegrationTests {

    private MockMvc mockMvc;// 模拟mvc对象

    @Autowired
    private DemoService demoService;// 注入测试bean

    @Autowired
    private WebApplicationContext context;// 注入webApplicationContext

    @SuppressWarnings("unused")
    @Autowired
    private MockHttpSession session;// 模拟http Session

    @SuppressWarnings("unused")
    @Autowired
    private MockHttpServletRequest request;// 模拟 http request

    /**
     * 初始化
     */
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();// 初始化
    }

    @Test
    public void testNomalController() throws Exception {
        mockMvc.perform(get("/normal"))// 模拟发送get请求"/nomal"
            .andExpect(status().isOk())// 预期返回值200
            .andExpect(view().name("page"))// 预设view的名称为page
            .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))// 页面跳转的真实路径
            .andExpect(model().attribute("msg", demoService.saySomething()));// 预期返回值
    }

    @Test
    public void testRestController() throws Exception {
        mockMvc.perform(get("/testRest"))// 模拟test请求
            .andExpect(status().isOk())// 200
            .andExpect(content().contentType("text/plain;charset=UTF-8"))// 预期返回值媒体类型
            .andExpect(content().string(demoService.saySomething()));// 预期返回值
    }

}
