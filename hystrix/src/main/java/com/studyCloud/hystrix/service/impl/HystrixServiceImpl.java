package com.studyCloud.hystrix.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.studyCloud.hystrix.aop.TimeOut;
import com.studyCloud.hystrix.service.HystrixService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Name;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class HystrixServiceImpl implements HystrixService {


    @TimeOut(name="hystrixTestTimeOutHandel1",value="3000")
    public String hystrixTestSuccess(Long id) {
        return "success";
    }

//    @HystrixCommand(fallbackMethod = "hystrixTestTimeOutHandel",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })

    @TimeOut(name="hystrixTestTimeOutHandel",value="3000")
    public String hystrixTestTimeOut(Long id) {
        long startTime = System.currentTimeMillis();
        int timeoutNum = 2;
        try {
            TimeUnit.SECONDS.sleep(timeoutNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();

        System.out.println(endTime-startTime);
        return "timeout";
    }

    public String hystrixTestTimeOutHandel(Long id) {
        return "哭唧唧";
    }

    public String hystrixTestTimeOutHandel1(Long id) {
        return "哭唧唧1";
    }


    @HystrixCommand(fallbackMethod = "hystrixCircuitBreakerHandel",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String hystrixCircuitBreaker(@RequestParam(value = "id") Long id){
        if (id < 0){
            throw new RuntimeException("id不能为负数");
        }
        String number = UUID.randomUUID().toString();
        return Thread.currentThread().getName()+"调用成功，流水号："+number;
    }

    public String hystrixCircuitBreakerHandel(@RequestParam(value = "id") Long id){
        return "系统出错，请稍后再试";
    }

}
