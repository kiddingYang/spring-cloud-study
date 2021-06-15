package com.studyCloud.hystrix.controller;


import com.studyCloud.hystrix.aop.TimeOut;
import com.studyCloud.hystrix.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hystrix/")
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @GetMapping("testSuccess")
    public String hystrixTestSuccess(@RequestParam(value = "id") Long id){
        return hystrixService.hystrixTestSuccess(id);
    }

    @GetMapping("timeout")
    public String hystrixTestTimeOut(@RequestParam(value = "id") Long id){
        return hystrixService.hystrixTestTimeOut(id);
    }

    @GetMapping("circuitBreaker")
    public String hystrixCircuitBreaker(@RequestParam(value = "id") Long id){
        return hystrixService.hystrixCircuitBreaker(id);
    }
}
