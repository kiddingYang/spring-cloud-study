package com.study.springCloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("zk/")
public class PaymentController {

    @GetMapping("getZookeeperInfo")
    public String getZookeeperInfo(){
        return "测试zookeeper成功";
    }

}
