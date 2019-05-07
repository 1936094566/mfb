package com.mc.mfb.admin.excpetion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理类
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/7
 * @Time:9:47
 *  RestControllerAdvice 全局切面
 *  CrossOrigin跨域
 *
 **/
@RestControllerAdvice
@CrossOrigin
public class GlobeException {
    //TODO 之后需要完善,自定义异常处理类

    @ExceptionHandler(NullPointerException.class)
    public String processException(Exception ex, HttpServletRequest request, HttpServletResponse response) {

        /**
         * 未知异常
         */
        logger.error(ex.toString());
        return "这里出错了";

    }
    private static Logger logger = LoggerFactory.getLogger(GlobeException.class);
}
