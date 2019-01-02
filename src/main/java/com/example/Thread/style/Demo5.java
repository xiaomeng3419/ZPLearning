package com.example.Thread.style;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhangpan on 2018/12/10.
 * 某个时间点上执行一个任务
 */
public class Demo5 {
    public static void main(String[] args) {
        Timer timer  = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer task running");
            }
        },0,1000);
    }
}
