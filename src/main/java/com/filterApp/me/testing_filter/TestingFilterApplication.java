package com.filterApp.me.testing_filter;

import com.filterApp.me.testing_filter.filter.with_order_interface.CustomFilterV3;
import org.apache.catalina.core.ApplicationFilterChain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

import java.util.Objects;

@SpringBootApplication

public class TestingFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingFilterApplication.class, args);
	}
    // Externalizing the thinking of rank
    @Bean
    FilterRegistrationBean<CustomFilterV3> customFilterV3FilterRegistrationBean (CustomFilterV3 customFilterV3){

        FilterRegistrationBean<CustomFilterV3> bean =  new FilterRegistrationBean<CustomFilterV3>(customFilterV3);
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;

    }
}
