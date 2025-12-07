package com.filterApp.me.testing_filter.filter.with_order_annotation;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Collections;

class HeaderFilterV2 extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(HeaderFilterV2.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String headerFormat = "Header: {%s} = {%s}";
        Collections.list(request.getHeaderNames()).forEach(
                header -> {
                    log.info(String.format(headerFormat,header,request.getHeader(header)));
                }
        );
        log.info("Passed HeaderLoggerFilter 2");
        filterChain.doFilter(request,response);
    }
}
