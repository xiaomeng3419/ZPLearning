package com.example.maoyanwork.scheduler;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.tools.ant.taskdefs.Sleep;
import org.hamcrest.Condition;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Location:com.example.maoyanwork.scheduler
 * Created by zhangpan
 * Date: 2019-05-31
 * Time: 15:02
 * Description:
 */
public class TaskScheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskScheduler.class);

    private static boolean isSuccess = false;
    public static volatile int num = 0;


    private  ScheduledThreadPoolExecutor taskCoordinator = new ScheduledThreadPoolExecutor(1, new BasicThreadFactory.Builder().namingPattern("task-coordinator-%d").daemon(true).build());

    public void ownerScheduler(int startTime, int endTime, int times, List<String> taskNames){

        num = endTime;

        int tempStartTime = startTime;
        taskCoordinator.scheduleAtFixedRate(() -> {
            System.out.println(num--);
            if (!taskNames.isEmpty()) {
                System.out.println();
            } else {
            }

        }, 5* 1, 1 * 2, TimeUnit.SECONDS);

        System.out.println("433333");

    }


    public void shutdownPool(){
        System.out.println("pool shutdown");
        taskCoordinator.shutdown();
    }


    @Test
    public void ownerSchedulerTest()throws Exception{
        ownerScheduler(1,10, 2,Lists.newArrayList());
        while (true){
            if (taskCoordinator.isShutdown()){
                break;
            }

        }
        ownerScheduler(1,10, 2,Lists.newArrayList());
        while (true){

        }
    }

}
