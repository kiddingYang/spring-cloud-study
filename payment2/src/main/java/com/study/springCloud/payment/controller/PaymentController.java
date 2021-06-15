package com.study.springCloud.payment.controller;

import com.study.springCloud.commons.bean.Payment;
import com.study.springCloud.commons.util.CommonResult;
import com.study.springCloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("create")
    public CommonResult createPayment(@RequestBody Payment payment) {
        int count = paymentService.createPayment(payment);
        if (count < 0) {
            return new CommonResult(999, "新增失败");
        } else {
            return new CommonResult(200, "新增成功");
        }
    }

    @GetMapping("getPaymentById")
    public CommonResult getPaymentById(@RequestParam(value = "id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        CommonResult commonResult;
        if (payment == null) {
            commonResult = new CommonResult(999, "查询支付信息失败，id" + id);
        } else {
            commonResult = new  CommonResult<Payment>(200, "查询成功,serverPort:"+serverPort, payment);
        }
        return commonResult;
    }

    @GetMapping("getPaymentLb")
    public String getPaymentLb() {
        return serverPort;
    }

}
