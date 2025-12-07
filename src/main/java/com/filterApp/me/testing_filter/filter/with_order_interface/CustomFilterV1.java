package com.filterApp.me.testing_filter.filter.with_order_interface;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Order(0)
public class CustomFilterV1 extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(CustomFilterV1.class);
    private final ApplicationContext applicationContext;

    public CustomFilterV1(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Passed CustomFilter V1");
        if (applicationContext.containsBean("customFilterV2")) {
            log.info("Custom filter v 2 detected");
        }
        filterChain.doFilter(request,response);
    }

}
