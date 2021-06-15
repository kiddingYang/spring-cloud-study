package com.studyCloud.hystrix.service;

public interface HystrixService {

    String hystrixTestSuccess(Long id );

    String hystrixTestTimeOut(Long id );

    String hystrixCircuitBreaker(Long id );

}
