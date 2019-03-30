package com.example.tencent;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by zhangpan on 2019/3/29.
 */
public class Yaxin {
//    InetAddress
Socket socket;
DataInputStream in;
DataOutputStream out;
public Yaxin(){
    try {
        socket = new Socket("localhost",8080);
        in = in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        System.out.println("总部消息"+in.readUTF()+"时刻");
        out.writeUTF("adsdsd");
    }catch (Exception e){
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        new Yaxin();
    }
}
