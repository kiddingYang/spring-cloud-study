package com.study.springCloud.feignHystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "hystrixService",fallback= FeignHystrixCallbackService.class)
public interface FeignHystrixService {

    @GetMapping("hystrix/testSuccess")
    String hystrixTestSuccess(@RequestParam(value = "id") Long id);

    @GetMapping("hystrix/timeout")
    String hystrixTestTimeOut(@RequestParam(value = "id") Long id);
}
