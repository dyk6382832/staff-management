package com.jiayu.staffmanagement.admin.servlet;


import com.jiayu.staffmanagement.admin.entity.AccountDTO;
import com.jiayu.staffmanagement.common.constant.AccountConstant;
import com.jiayu.staffmanagement.common.util.CommonUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @version: 1.00.00
 * @description:
 * @copyright: Copyright (c) 2020 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chenyueqi
 * @date: 2021-07-08 9:30
 */

@WebFilter(filterName = "LoginFilter",urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        AccountDTO accountDTO = CommonUtils.getAdminInfoFromSession(req);
        // 无session，且不是登录路径或不是登录页面或不是静态资源。均跳转至登录页面
        String spath = req.getServletPath();
        String[] urls = {"/login","/api","/json",".js",".css",".ico",".jpg",".png", ".otf", ".eot", ".svg", ".ttf", ".woff", ".woff2", ".less", ".scss"};
        boolean flag = true;
        for (String str : urls) {
            if (spath.indexOf(str) != -1) {
                flag =false;
                break;
            }
        }
        if (flag) {
            if (Objects.nonNull(accountDTO)) {
                chain.doFilter(request, response);
                return;
            }
            resp.sendRedirect(req.getContextPath()+ AccountConstant.VIEW_LOGIN_URL);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}


}
