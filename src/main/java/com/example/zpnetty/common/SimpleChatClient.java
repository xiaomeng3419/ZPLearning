package com.example.zpnetty.common;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

public class SimpleChatClient {
    private static String host = "localhost";
    private static int port = 8080;

    public static void main(String[] args) throws Exception{
        new SimpleChatClient(host,port).run();
    }
    public SimpleChatClient(String host, int port)
    {
        this.host = host;
        this.port = port;
    }
    public void run() throws Exception
    {
        //NioEventLoopGroup可以理解为一个线程池，内部维护了一组线程，每个线程负责处理多个Channel上的事件，而一个Channel只对应于一个线程，
        // 这样可以回避多线程下的数据同步问题。
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //通过这个来链接服务器
            Bootstrap bootstrap  = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new SimpleChatClientInitializer());
            Channel channel = bootstrap.connect(host, port).sync().channel();
            channel.closeFuture().sync();//阻塞到channel直接关闭
            Scanner sc = new Scanner(System.in);
            System.out.println("please enter...");
            boolean exit = false;
            // 输入exit，退出系统
            while(!exit)
            {
                String str = sc.next();
                channel.writeAndFlush(str + "\r\n");
                if(str.equalsIgnoreCase("exit"))
                {
                    exit = true;
                    channel.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }
}
