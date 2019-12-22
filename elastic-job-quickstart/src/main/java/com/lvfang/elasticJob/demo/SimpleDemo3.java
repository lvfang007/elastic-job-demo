package com.lvfang.elasticJob.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0
 **/
public class SimpleDemo3 {
    public static void main(String[] args) {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.scheduleAtFixedRate(
                new Runnable() {
                    public void run() {
                        //TODO：something
                        System.out.printf("time:%s,to do222...\n", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
                    }
                }, 1,
                3, TimeUnit.SECONDS);
    }
}
