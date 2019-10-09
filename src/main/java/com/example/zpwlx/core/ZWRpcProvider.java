package com.example.zpwlx.core;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangpan on 2019/7/20.
 * 将需要发布的服务存储在一个内存变量serviceList中
 启动socket，server.accept()方法阻塞在那，监听输入
 针对每一个请求，单独启动一个线程处理(和面可以处理为交给线程池处理)
 */
public class ZWRpcProvider {

    //存储注册的服务列表
    private static List<Object> serviceList;

    /**
     * 发布rpc服务
     * @param port
     * @throws Exception
     */
    public static void export(int port,Object... services) throws Exception {
        serviceList= Arrays.asList(services);
        ServerSocket server = new ServerSocket(port);
        Socket client = null;
        while (true) {
            //阻塞等待输入
            client = server.accept();
            //每一个请求，启动一个线程处理
            if (client == null){
                System.out.println("current request is empty!");
            }else {
                System.out.println("request is runging ");
                new Thread(new ServerThread(client,serviceList)).start();
            }
        }
    }
}
