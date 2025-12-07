package com.filterApp.me.testing_filter.filter.with_order_annotation;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class HeaderLogger extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(HeaderLogger.class);

    @Override
    public void doFilterInternal(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String headerLogFormat = "Header : {%s} = {%s}";
        Collections.list(servletRequest.getHeaderNames()).forEach(
                header -> {
                    log.info(String.format(headerLogFormat,header,servletRequest.getHeader(header)));
                }
        );
        log.info("Passed HeaderLoggerFiler 1");
        filterChain.doFilter(servletRequest,servletResponse);//exit point
    }
}
