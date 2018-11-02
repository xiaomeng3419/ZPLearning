package com.example.zpnetty.tian;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author zhangpan
 * @date 18-10-23 下午3:44
 * @package com.example.zpnetty.tian
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    private byte[] req=("QUERY TIME ORDER" + System.getProperty(System.lineSeparator())).getBytes();
    @Override
    public void channelActive(ChannelHandlerContext ctx) {//1
        System.out.println("channelActive");
//        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
        ByteBuf message = Unpooled.buffer(req.length);
        message.writeBytes(req);
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("channelRead");
        System.out.println("Now is:" + body);
    }
}