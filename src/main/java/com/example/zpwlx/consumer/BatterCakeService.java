package com.example.zpwlx.consumer;

import com.example.task.Scheduler;
import com.example.zpproxy.IMath;

import java.util.Comparator;

/**
 * Created by zhangpan on 2019/7/20.
 */
public interface BatterCakeService extends Scheduler, IMath{
    /**
     * 卖煎饼的服务
     * @param name
     * @return
     */
    public String sellBatterCake(String name);
}