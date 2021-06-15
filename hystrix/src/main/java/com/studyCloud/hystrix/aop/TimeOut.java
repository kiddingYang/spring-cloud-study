package com.studyCloud.hystrix.aop;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimeOut {

    String name();

    String value();
}
