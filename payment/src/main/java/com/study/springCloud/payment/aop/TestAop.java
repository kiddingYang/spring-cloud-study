package com.study.springCloud.payment.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class TestAop {

    @Around("execution(* com.study.springCloud.payment.service.*.* (..))")
    public Object aroundService(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        for(Object object :args){
            System.out.println("养鸡让我打印："+object);
        }
        Object object =  point.proceed(args);
        System.out.println("养鸡让我再次打印："+object);
        return object;
    }


//    @AfterReturning(pointcut="execution(* com.study.springCloud.payment.service.*.* (..))",returning="returnValue")
    @AfterReturning(value="@annotation(com.study.springCloud.payment.aop.LogAnnotaion)", returning="returnValue")
    public void afterReturning(JoinPoint point,Object returnValue) throws Throwable {
        System.out.println("养鸡让我返回结果："+returnValue);
    }

    @AfterThrowing("execution(* com.study.springCloud.payment.service.*.* (..))")
    public void releaseResource(JoinPoint point) {
        System.out.println("@After：模拟释放资源...");
        System.out.println("@After：目标方法为：" +
                point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("@After：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("@After：被织入的目标对象为：" + point.getTarget());
    }

}
