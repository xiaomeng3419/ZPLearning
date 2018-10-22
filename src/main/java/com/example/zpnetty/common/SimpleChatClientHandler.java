package com.example.zpnetty.common;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;


public class SimpleChatClientHandler extends SimpleChannelInboundHandler {
    Logger log = Logger.getLogger(SimpleChatClientHandler.class);

//    优先级高于messageReceived方法，有了这个方法就会屏蔽messageReceived方法
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println(msg.toString());
//    }
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        log.info("logger netty handler : {}"+String.valueOf(o));
        System.out.println(o);

    }
}
