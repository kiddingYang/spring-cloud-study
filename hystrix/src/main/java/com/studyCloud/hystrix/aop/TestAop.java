//package com.studyCloud.hystrix.aop;
//
//import com.google.common.base.Joiner;
//import com.study.springCloud.commons.bean.LogInfo;
//import com.studyCloud.hystrix.dao.LogInfoDao;
//import lombok.SneakyThrows;
//import org.apache.commons.lang.StringUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.Future;
//
//@Aspect
//@Component
//public class TestAop {
//
//
//    ExecutorService executorService = Executors.newFixedThreadPool(5);
//
//    @Resource
//    LogInfoDao logInfoDao;
//
//    @Around("execution(* com.studyCloud.hystrix.controller.*.* (..))")
//    public Object paramValue(ProceedingJoinPoint joinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        Object[] args = joinPoint.getArgs();
//
//
//        final Object proceed = joinPoint.proceed(args);
//
//        long endTime  = System.currentTimeMillis();
//
//        final long time = endTime-startTime;
//
//        StringBuffer sbf = new StringBuffer();
//        for (Object arg : args) {
//            sbf = sbf.append(arg).append(",");
//            System.out.println(sbf);
//        }
//        final String param = sbf.substring(0,sbf.length()-1);
//
//
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//
//        final  String requestURL = request.getRequestURL().toString();
//
//        executorService.submit(new Runnable() {
//            @SneakyThrows
//            public void run() {
//                Thread.sleep(10000);
//                LogInfo logInfo  = new LogInfo();
//                logInfo.setUrl(requestURL);
//                logInfo.setParam(param);
//                logInfo.setResult(proceed.toString());
//                logInfo.setTime(String.valueOf(time));
//                logInfoDao.createLoginfo(logInfo);
//            }
//        });
//
//        Future<Object> submit = executorService.submit(new Callable<Object>() {
//            public Object call() throws Exception {
//                return "a";
//            }
//        });
//        Object o = submit.get();
//        System.out.println("->>>>>>>>>>>" + o);
////            final Thread thread = new Thread(new Runnable() {
////            @SneakyThrows
////            public void run() {
////
////                Thread.sleep(10000);
////                LogInfo logInfo  = new LogInfo();
////                logInfo.setUrl(requestURL);
////                logInfo.setParam(param);
////                logInfo.setResult(proceed.toString());
////                logInfo.setTime(String.valueOf(time));
////                logInfoDao.createLoginfo(logInfo);
////            }
////        });
////        thread.start();
//
//        System.out.println("请求url："+requestURL+",请求参数："+param+",返回结果："+proceed+"接口执行时间："+time);
//
//
//
//        return proceed;
//    }
//}
