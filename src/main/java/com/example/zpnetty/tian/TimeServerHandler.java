package com.example.zpnetty.tian;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author zhangpan
 * @date 18-10-23 下午3:39
 * @package com.example.zpnetty.tian
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception { // 1
        System.out.println("channelRead");
        String request = (String) msg; //2
        System.out.println(request);
        String response = null;
        if ("QUERY TIME ORDER".equals(request)) { // 3
            response = new Date(System.currentTimeMillis()).toString();
        } else {
            response = "BAD REQUEST";
        }
        response = response + System.getProperty(System.lineSeparator());
         ByteBuf resp = Unpooled.copiedBuffer(response.getBytes()); // 5
        ctx.writeAndFlush(resp); // 6
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        System.out.println("channel 通道 Read 读取 Complete 完成");
        ctx.flush();
    }
}