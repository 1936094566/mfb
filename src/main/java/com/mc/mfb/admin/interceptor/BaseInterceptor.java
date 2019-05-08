package com.mc.mfb.admin.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/7
 * @Time:10:34
 * 通用拦截器,用于记录用户访问时间
 **/
public class BaseInterceptor implements HandlerInterceptor  {
    private static final Logger logger = LoggerFactory.getLogger(BaseInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 对来自后台的请求统一进行日志处理
         */
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        Map<String, String[]> map=request.getParameterMap();
        System.out.println("---------------------------------------------------------------------------------------------------");
        map.forEach((k,v) ->{
            logger.info("请求参数-- "+k+": "+v[0]);
        });
        logger.info("url--"+url);
        logger.info("method--"+method);
        logger.info("uri--"+uri);
        System.out.println("---------------------------------------------------------------------------------------------------");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
