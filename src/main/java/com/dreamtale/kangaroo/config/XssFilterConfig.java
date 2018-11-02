package com.dreamtale.kangaroo.config;

import com.dreamtale.kangaroo.core.filter.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import static javax.servlet.DispatcherType.REQUEST;

@Component
public class XssFilterConfig {
    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new XssFilter());
        registration.addUrlPatterns("/*");
        registration.setName("XssSqlFilter");
        registration.setDispatcherTypes(REQUEST);
        registration.setOrder(1);
        return registration;
    }
}
