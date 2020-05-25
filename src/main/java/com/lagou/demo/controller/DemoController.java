package com.lagou.demo.controller;

import com.lagou.demo.annotations.Security;
import com.lagou.demo.service.IDemoService;
import com.lagou.edu.mvcframework.annotations.LagouAutowired;
import com.lagou.edu.mvcframework.annotations.LagouController;
import com.lagou.edu.mvcframework.annotations.LagouRequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@LagouController
@LagouRequestMapping("/demo")
public class DemoController {


    @LagouAutowired
    private IDemoService demoService;


    /**
     * URL: /demo/query
     *
     * @param request
     * @param response
     * @param username
     * @return
     */
    @LagouRequestMapping("/query")
    @Security(value = {"zhangsan", "lisi"})
    public void query(HttpServletRequest request, HttpServletResponse response, String username) throws IOException {
        response.getWriter().println(demoService.get(username));
    }

    /**
     * URL: /demo/query
     *
     * @param request
     * @param response
     * @param username
     * @return
     */
    @LagouRequestMapping("/insert")
    @Security(value = {"wangwu"})
    public void insert(HttpServletRequest request, HttpServletResponse response, String username) throws IOException {
        response.getWriter().println(demoService.get(username));
    }
}
