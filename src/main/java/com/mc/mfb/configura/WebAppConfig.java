package com.mc.mfb.configura;

import com.mc.mfb.admin.interceptor.BaseInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Created with IDEA
 * @author:麻超
 * @Date:2019/5/7
 * @Time:10:40
 * WEB 新创建的拦截器在这注入到springboot中
 *
 *  如果继承WebMvcConfigurationSupport会导致registry里Interceptor只有一个
 **/
@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    /**
     * //等部署完了，将这个方法注释一下看看。
     *  指定该类拦截的url
     *  指定拦截器类
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new BaseInterceptor())
                .addPathPatterns("/**");
    }
}
