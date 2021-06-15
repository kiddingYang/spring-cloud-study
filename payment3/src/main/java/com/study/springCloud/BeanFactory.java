//package com.study.springCloud;
//
//import com.netflix.loadbalancer.RandomRule;
//import com.study.springCloud.controller.PaymentController;
//import org.springframework.context.annotation.Bean;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class BeanFactory {
//
//
//    private static Map<String,Object> beans = new HashMap<String, Object>();
//
//    static {
//        beans.put("MySelfRule", new MySelfRule());
//        beans.put("MySelfRule", new RandomRule());
//    }
//
//    public Object getBean(String myRule) {
//
//        return beans.get(name);
//    }
//
//    public Object getBean(Class clazz) {
//
//        return "";
//    }
//
//}
