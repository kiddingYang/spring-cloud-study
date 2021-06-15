package com.study.feign.controller;

import com.study.feign.service.PaymentFeignService;
import com.study.springCloud.commons.bean.Payment;
import com.study.springCloud.commons.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    PaymentFeignService paymentFeignService;

    @GetMapping("getPaymentById")
    public CommonResult<Payment> getPaymentById(@RequestParam(value = "id") Long id) {
        CommonResult<Payment> paymentById = paymentFeignService.getPaymentById(id);
        return paymentById;
    }
}
