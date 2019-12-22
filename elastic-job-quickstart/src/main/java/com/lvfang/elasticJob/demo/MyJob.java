package com.lvfang.elasticJob.demo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 * @version 1.0
 **/
public class MyJob implements Job {

    public void execute(JobExecutionContext jobExecutionContext){
        System.out.printf("time:%s,to do...\n", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
    }
}
