package com.study.springCloud.payment.service.impl;

import com.study.springCloud.commons.bean.Payment;
import com.study.springCloud.payment.aop.LogAnnotaion;
import com.study.springCloud.payment.dao.PaymentDao;
import com.study.springCloud.payment.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao  paymentDao;


    //    @LogAnnotaion
    @Transactional
    public int createPayment(Payment payment) {
        // insert
        // delete  xx
        // update
        return paymentDao.createPayment(payment);
    }

    @LogAnnotaion
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
