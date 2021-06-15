package com.studyCloud.hystrix;

import java.util.concurrent.Callable;

public class Main {


    public static void main(String[] args) throws Exception {
        Thread currentThread = Thread.currentThread();

        Thread thread = new Thread(new MyRunnable());
        thread.start();
        Thread.sleep(5000);



        System.out.println(currentThread +":" + thread.getName());
    }


    public static class MyRunnable implements Runnable {

        public void run() {
            int a = 1;
            int b = 2;
            System.out.println(a + b);
        }
    }


    public static class MyCallable implements Callable {

        public Object call() throws Exception {
            return null;
        }
    }


}
