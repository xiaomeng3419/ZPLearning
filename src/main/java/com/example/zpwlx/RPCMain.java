package com.example.zpwlx;

import com.example.zpwlx.consumer.BatterCakeService;
import com.example.zpwlx.consumer.BatterCakeServiceImpl;
import com.example.zpwlx.core.ZWRpcProvider;

/**
 * Created by zhangpan on 2019/7/20.
 */
public class RPCMain {
    public static void main(String[] args) throws Exception {
        BatterCakeService batterCakeService =new BatterCakeServiceImpl();
        //发布卖煎饼的服务，注册在20006端口
        ZWRpcProvider.export(20006,batterCakeService);
    }
}
