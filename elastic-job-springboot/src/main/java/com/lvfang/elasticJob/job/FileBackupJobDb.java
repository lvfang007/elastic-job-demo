package com.lvfang.elasticJob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.lvfang.elasticJob.model.FileCustom;
import com.lvfang.elasticJob.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 文件备份任务
 * @author Administrator
 * @version 1.0
 **/
@Component
public class FileBackupJobDb implements SimpleJob {

    //每次任务执行要备份文件的数量
    private final int FETCH_SIZE = 1;

    @Autowired
    FileService fileService;

    //任务执行代码逻辑
    public void execute(ShardingContext shardingContext) {
        System.out.println("作业分片："+shardingContext.getShardingItem());
        //分片参数，（0=text,1=image,2=radio,3=vedio，参数就是text、image...）
        String jobParameter = shardingContext.getShardingParameter();
        //获取未备份的文件
        List<FileCustom> fileCustoms = fetchUnBackupFiles(jobParameter,FETCH_SIZE);
        //进行文件备份
        backupFiles(fileCustoms);
    }

    /**
     * 获取未备份的文件
     * @param count   文件数量
     * @return
     */
    public List<FileCustom> fetchUnBackupFiles(String fileType,int count){

        List<FileCustom> fileCustoms = fileService.fetchUnBackupFiles(fileType, count);
        System.out.printf("time:%s,获取文件%d个\n",
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()),
                count);
        return fileCustoms;

    }

    /**
     * 文件备份
     * @param files
     */
    public void backupFiles(List<FileCustom> files){
        fileService.backupFiles(files);
    }
}
