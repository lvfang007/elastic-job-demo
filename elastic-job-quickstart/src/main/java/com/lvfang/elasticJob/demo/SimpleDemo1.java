package com.lvfang.elasticJob.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * @version 1.0
 **/
public class SimpleDemo1 {
    public static void main(String[] args) {

        //任务执行间隔时间
        final long timeInterval = 3000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    System.out.printf("time:%s,to do...\n", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
