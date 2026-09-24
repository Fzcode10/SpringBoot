package com.example.FiltersDemo.Configuration;

import com.example.FiltersDemo.filter.SecondDay.DummyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<DummyFilter> getDummyFilterBean() {
        FilterRegistrationBean<DummyFilter> registrationBean =
                new FilterRegistrationBean<>();

        registrationBean.setFilter(new DummyFilter());

        //registrationBean.setOrder();

//        registrationBean.addUrlPatterns("/api/*, /admin/*");

        return registrationBean;
    }
}