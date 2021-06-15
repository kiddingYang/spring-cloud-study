package com.study.springCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ZkOrderController {

    private String url = "http://payment";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/zkOrder/paymentInfo")
    public String paymentInfo(){
        return restTemplate.getForObject(url+"/zk/getZookeeperInfo",String.class);
    }
}
