package com.study.springCloud.payment.dao;

import com.study.springCloud.commons.bean.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {

    int createPayment(Payment payment);

    Payment getPaymentById(Long id);
}
