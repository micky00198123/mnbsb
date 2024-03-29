package com.qklt.mnbsb.config;

import com.qklt.mnbsb.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("/html/login");
        registry.addViewController("/html/login")
                .setViewName("/html/login");
        registry.addViewController("/html/register")
                .setViewName("/html/register");
        registry.addViewController("/html/welcome")
                .setViewName("/html/welcome");
        registry.addViewController("/html/home")
                .setViewName("/html/home");
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/html/welcome");
    }

}
