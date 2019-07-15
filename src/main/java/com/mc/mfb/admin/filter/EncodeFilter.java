package com.mc.mfb.admin.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/7
 * @Time:10:38
 * 编码过滤器
 **/
@Configuration
public class EncodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        //没有这一句程序不往下执行
        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
