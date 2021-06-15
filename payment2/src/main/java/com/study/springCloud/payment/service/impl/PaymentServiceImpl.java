package com.study.springCloud.payment.service.impl;

import com.study.springCloud.commons.bean.Payment;
import com.study.springCloud.payment.dao.PaymentDao;
import com.study.springCloud.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao  paymentDao;

    public int createPayment(Payment payment) {
        return paymentDao.createPayment(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
