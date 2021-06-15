package com.study.springCloud.payment.service;


import com.study.springCloud.commons.bean.Payment;

public interface PaymentService {

    int createPayment(Payment payment);

    Payment getPaymentById(Long id);
}
