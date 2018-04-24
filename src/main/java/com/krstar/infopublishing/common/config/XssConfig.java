package com.krstar.infopublishing.common.config;


/*
    *@Author:jhy
    *@Despriction:过滤特殊字符
    *@Date:Created in 13:12 2018/4/24
    *@Modify By:
    */

import com.krstar.infopublishing.common.filter.XssFilter;
import org.springframework.context.annotation.Configuration;
import com.google.common.collect.Maps;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
@Configuration
public class XssConfig {
    /**
     * xss过滤拦截器
     */
    @Bean
    public FilterRegistrationBean xssFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new XssFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String, String> initParameters = Maps.newHashMap();
        initParameters.put("excludes", "/favicon.ico,/img/*,/js/*,/css/*");
        initParameters.put("isIncludeRichText", "true");
        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;

    }
}