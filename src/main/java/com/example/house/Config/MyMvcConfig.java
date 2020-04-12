package com.example.house.Config;

import com.example.house.Controller.LoginController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * @param registry 视图解析器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("Login");
        registry.addViewController("/main.html").setViewName("Main");
        registry.addViewController("/release.html").setViewName("release");
        registry.addViewController("/success.html").setViewName("success");
        registry.addViewController("/register.html").setViewName("register");
    }

    /**
     * @param registry 登录拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //excludePathPatterns 对那个页面 操作不拦截
        registry.addInterceptor(new LoginUsersInterceptor()).excludePathPatterns("/", "/register.html", "/asserts/**", "/loginUsers", "/addUsers", "/checkUsersName", "/checkTel");
//        registry.addInterceptor(new MainUsersInterceptor()).addPathPatterns("/", "/register.html", "/loginUsers", "/addUsers", "/checkUsersName", "/checkTel");
        registry.addInterceptor(new MainShowUsersInterceptor()).addPathPatterns("/release.html");
    }
}
