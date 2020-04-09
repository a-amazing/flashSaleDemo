package com.wangyi.flashsale.config;

import com.wangyi.flashsale.common.limiter.GuavaLimiter;
import com.wangyi.flashsale.common.limiter.Limiter;
import com.wangyi.flashsale.interceptor.LimitInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author:wangyi
 * @Date:2020/4/9
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public LimitInterceptor createLimitInterceptor(){
        LimitInterceptor limitInterceptor = new LimitInterceptor();
        limitInterceptor.setLimiter(createLimiter());
        return limitInterceptor;
    }

    @Bean
    public Limiter createLimiter(){
        return new GuavaLimiter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(createLimitInterceptor()).addPathPatterns("/*");
    }
}
