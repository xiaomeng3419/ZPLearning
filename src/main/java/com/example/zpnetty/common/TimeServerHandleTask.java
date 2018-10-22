package com.example.zpnetty.common;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;

public class TimeServerHandleTask implements Runnable {
    SocketChannel socketChannel;
    ExecutorService executorService;
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

    public TimeServerHandleTask(SocketChannel socketChannel, ExecutorService executorService) {
        this.socketChannel = socketChannel;
        this.executorService = executorService;
    }

    @Override
    public void run() {
        try {
            if(socketChannel.read(byteBuffer)>0){
                while (true){
                    byteBuffer.flip();
                    if(byteBuffer.remaining()<"GET CURRENT TIME".length()){
                        byteBuffer.compact();
                        socketChannel.read(byteBuffer);
                        continue;
                    }
                    byte[] request=new byte[byteBuffer.remaining()];
                    byteBuffer.get(request);
                    String requestStr=new String(request);
                    byteBuffer.clear();
                    if (!"GET CURRENT TIME".equals(requestStr)) {
                        socketChannel.write(byteBuffer.put("BAD_REQUEST".getBytes()));
                    } else {
                        ByteBuffer byteBuffer = this.byteBuffer.put(Calendar.getInstance()
                                .getTime().toLocaleString().getBytes("UTF-8"));
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                    }

                }
            }
            TimeServerHandleTask currentTask = new TimeServerHandleTask(socketChannel,
                    executorService);
            executorService.submit(currentTask);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
