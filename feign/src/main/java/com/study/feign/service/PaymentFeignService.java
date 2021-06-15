package com.study.feign.service;

import com.study.springCloud.commons.bean.Payment;
import com.study.springCloud.commons.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "payment")
public interface PaymentFeignService {

    @GetMapping("payment/getPaymentById")
    CommonResult<Payment> getPaymentById(@RequestParam(value = "id") Long id);
}
