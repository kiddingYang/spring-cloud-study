package com.study.springCloud.feignHystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.study.springCloud.feignHystrix.service.FeignHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
//@DefaultProperties(defaultFallback = "hystrixTestTimeOutHandel")
public class FeignHystrixController {

    @Autowired
    private FeignHystrixService feignHystrixService;

    @GetMapping("testSuccess")
    public String hystrixTestSuccess(@RequestParam(value = "id") Long id){
        return feignHystrixService.hystrixTestSuccess(id);
    }

    @GetMapping("timeout")
//    @HystrixCommand(fallbackMethod = "hystrixTestTimeOutHandel",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
//    @HystrixCommand
    public String hystrixTestTimeOut(@RequestParam(value = "id") Long id){
        return feignHystrixService.hystrixTestTimeOut(id);
    }

    public String hystrixTestTimeOutHandel(@RequestParam(value = "id") Long id){
        return "呼啦啦";
    }



}
