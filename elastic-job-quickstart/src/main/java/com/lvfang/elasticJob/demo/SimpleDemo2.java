package com.lvfang.elasticJob.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Administrator
 * @version 1.0
 **/
public class SimpleDemo2 {
    public static void main(String[] args) {

        Timer timer = new Timer();
        Timer timer2 = new Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {

                System.out.printf("time:%s,to do111...\n", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

            }
        }, 1000, 2000);  //1秒后开始调度，每2秒执行一次
        timer2.schedule(new TimerTask(){
            @Override
            public void run() {
                System.out.printf("time:%s,to do222...\n", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));

            }
        }, 1000, 3000);  //1秒后开始调度，每3秒执行一次
    }
}
