package com.ayang818.trainbooking.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebConfig
 * @Description 配置拦截器
 * @Author 杨丰畅
 * @Date 2019/12/4 20:41
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    SessionInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }

}
