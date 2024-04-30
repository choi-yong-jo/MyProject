package com.cafe.mall.sample;

import com.cafe.mall.sample.interceptor.PerformanceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private PerformanceInterceptor performanceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(performanceInterceptor)
//                .addPathPatterns("/**")
                .addPathPatterns("/rest-api-root/**")
                .excludePathPatterns("/css/**", "/js/**", "/image/**");     // 인터셉터 적용 대상
    }
}
