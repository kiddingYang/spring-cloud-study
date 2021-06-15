package com.study.springcloud.order.controller;

import com.study.springCloud.commons.bean.Payment;
import com.study.springCloud.commons.util.CommonResult;
import com.study.springcloud.order.lb.LoadBalancer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("order/")
public class OrderController{
    private String url ="http://payment/payment/";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping("create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        return restTemplate.postForObject(url+"create",payment, CommonResult.class);
    }

    @GetMapping("getPaymentById")
    public CommonResult getPaymentById(@RequestParam(value = "id") Long id) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("payment");
//        String url = "http://payment/payment/getPaymentById";
//        // ==> "http://localhost:8083/payment/getPaymentById";
//        String url2 =instances.get(0).getUri().toString();
//        url = url.replaceFirst("payment", "127.0.0.1:8083");
//        return restTemplate.getForObject(instances.get(0).getUri()+"/payment/"+"getPaymentById?id="+id,CommonResult.class);

        return restTemplate.getForObject(url +"getPaymentById?id="+id,CommonResult.class);
    }

    @GetMapping("getPayment2ById")
    public CommonResult getPayment2ById(@RequestParam(value = "id") Long id) {
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(url+"getPaymentById?id="+id,CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else {
            return new CommonResult(400,"查询失败");
        }
    }

    @GetMapping("getPaymentLb")
    public String getPaymentLb() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("payment");
        if (serviceInstances==null && serviceInstances.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(serviceInstances);
        return restTemplate.getForObject(serviceInstance.getUri()+"/payment/getPaymentLb",String.class);
    }

}
