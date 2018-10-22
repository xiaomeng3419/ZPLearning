package com.example.zpnetty.common;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

public class EchoServer {

    //端口号
    private static int port = 7777;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        EchoServer server = new EchoServer();
        server.startup();
    }

    public void startup(){

        ServerBootstrap sb = new ServerBootstrap();
        //主从reactor模式
        sb.group(new NioEventLoopGroup(), new NioEventLoopGroup());
        //指定IO类型
        sb.channel(NioServerSocketChannel.class);
        //设置handler
        sb.childHandler(new EchoServerChannelPipeline());

        ChannelFuture future = sb.bind(new InetSocketAddress(port));
        future.addListener(new ChannelFutureListener() {

            @Override
            public void operationComplete(ChannelFuture f) throws Exception {
                // TODO Auto-generated method stub
                if(f.isSuccess()){
                    System.out.println("bind success,listening on "+port);
                }else{
                    System.out.println("bind failed");
                }
            }
        });
    }

    /**
     *
     * @author Eric
     *
     */
    public class EchoServerChannelPipeline extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            // TODO Auto-generated method stub
            ChannelPipeline pipeline = ch.pipeline();
            //添加InboundHandler
            pipeline.addLast(new MySimpleChannelInboundHandler());
        }
    }


    public class ChannelFutureListenerzp implements ChannelFutureListener{

//        @Override
        public void operationComplete(ChannelFuture f) throws Exception {
            // TODO Auto-generated method stub
            if(f.isSuccess()){
                System.out.println("bind success,listening on "+port);
            }else{
                System.out.println("bind failed");
            }
        }
    }
    /**
     * handler
     * @author Eric
     *
     */
    public class MySimpleChannelInboundHandler extends ChannelInboundHandlerAdapter {
        /**
         * 处理业务逻辑
         */
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            if (msg instanceof ByteBuf){
                ByteBuf data = (ByteBuf) msg;
                //拷贝一份数据
                ByteBuf readCpoy = data.copy();
                int idx = readCpoy.readableBytes();
                byte[] bytes = readCpoy.readBytes(idx).array();
                System.out.println("read data:\n"+new String(bytes));
            }
            //写回去
            ctx.write(msg);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            //读完后flush空数据
            ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            // 异常
            System.out.println("exception happend from indound:"+cause.getMessage());
            ctx.close();
        }
    }
}
