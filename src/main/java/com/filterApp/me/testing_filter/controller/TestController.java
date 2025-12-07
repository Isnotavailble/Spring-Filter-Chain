package com.filterApp.me.testing_filter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {
    @GetMapping("/")
    public ResponseEntity<?> testController(){
        return ResponseEntity.ok("Request reached");
    }
}
