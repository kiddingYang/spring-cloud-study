package com.study.springcloud.order.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLb implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAtomic(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current>=10000?0:current+1;
        }while(this.atomicInteger.compareAndSet(current,next));
        return next;
    }



    public ServiceInstance instances(List<ServiceInstance> instances) {
        int index =getAtomic()%instances.size();
        return instances.get(index);
    }
}
