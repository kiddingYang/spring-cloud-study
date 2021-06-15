//package com.studyCloud.hystrix.aop;
//
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//
//@Aspect
//@Component
//public class HystrixAop {
//
//
//    @Around(value = "@annotation(com.studyCloud.hystrix.aop.TimeOut)")
//    public Object hystrixTimeout(final ProceedingJoinPoint joinPoint) throws Throwable {
//
//        Signature signature = joinPoint.getSignature();
//        Method method = ((MethodSignature) signature).getMethod();
//        final TimeOut timeOut = method.getAnnotation(TimeOut.class);
//        final String timeout = timeOut.value();
//
//        final long startTime = System.currentTimeMillis();
//
//        final Thread currentThread = Thread.currentThread();
//
//        final Boolean[] interrupt = {false};
//
//        Thread thread = new Thread(new Runnable() {
//            public void run() {
//                while (true) {
//                    boolean shouldBeInterrupted = System.currentTimeMillis() - startTime > Integer.valueOf(timeout);
//                    if (shouldBeInterrupted && !currentThread.isInterrupted()) {
//                        currentThread.interrupt();
//                        interrupt[0] = true;
//                        break;
//                    }
//
//                }
//            }
//        });
//        thread.start();
//
//        Object[] args = joinPoint.getArgs();
//        Object proceed = joinPoint.proceed(args);
//        if (interrupt[0]) {
//
//            String name = timeOut.name();
//
//            Method fallbackMethod;
//            Object target = joinPoint.getTarget();
//            if (args != null) {
//                Class[] argClass = new Class[args.length];
//                for (int i = 0; i < args.length; i++) {
//                    argClass[i] = args[i].getClass();
//                }
//
//                fallbackMethod = target.getClass().getMethod(name, argClass);
//            } else {
//                fallbackMethod = target.getClass().getMethod(timeOut.name());
//            }
//            return fallbackMethod.invoke(target, args);
//        } else {
//            return proceed;
//        }
//    }
//
//
//}
