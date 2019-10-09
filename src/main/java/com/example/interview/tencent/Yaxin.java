package com.example.interview.tencent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
        System.out.println("�ܲ���Ϣ"+in.readUTF()+"ʱ��");
        out.writeUTF("adsdsd");
    }catch (Exception e){
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        new Yaxin();
    }
}
