package com.study.springCloud.feignHystrix.service;

import org.springframework.stereotype.Service;


@Service
public class FeignHystrixCallbackService implements FeignHystrixService{
    public String hystrixTestSuccess(Long id) {
        return "养鸡理我了";
    }

    public String hystrixTestTimeOut(Long id) {
        return "养鸡不理我了";
    }

}
