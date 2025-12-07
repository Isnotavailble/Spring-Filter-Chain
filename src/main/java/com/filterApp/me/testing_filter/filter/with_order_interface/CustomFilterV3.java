package com.filterApp.me.testing_filter.filter.with_order_interface;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
// using FilterRegistrationBean technique
// this class set order method is in Bean check in main class

public class CustomFilterV3 extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(CustomFilterV3.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Passed CustomFilterV2");
        filterChain.doFilter(request,response);
    }

}
