package com.example.zpwlx.core;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.List;
import java.util.Objects;

/**
 * Created by zhangpan on 2019/7/20.
 * 读取客户端发送的服务名
 判断服务是否发布
 如果发布，则走反射逻辑，动态调用，返回结果
 如果未发布，则返回提示通知
 */
public class ServerThread implements Runnable{
    private Socket client = null ;
    private List<Object> serviceList = null;
    public  ServerThread(Socket client,List<Object> serviceList){
        this.client = client;
        this.serviceList  = serviceList;
    }

    @Override
    public void run() {
        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        try{
            input = new ObjectInputStream(client.getInputStream());
            output= new ObjectOutputStream(client.getOutputStream());
            Class serviceClass  = (Class)input.readObject();
            Object obj = findService(serviceClass);
            if(Objects.isNull(obj)){
                output.writeObject(serviceClass.getName()+"missing pushlish success");
            }else {
                try{
                    String methodName = input.readUTF();
                    Class<?>[] parameterTypes  = (Class<?>[])input.readObject();
                    Object[] arguments = (Object[])input.readObject();
                    Method method = obj.getClass().getMethod(methodName,parameterTypes);
                    Object result = method.invoke(obj,arguments);
                    output.writeObject(result);
                }catch(Exception e){
                    output.writeObject(e);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                client.close();
                input.close();
                output.close();
            }catch (Exception e){
                System.out.println("close error!");
            }
        }
    }


    private Object findService (Class serviceClass){
        for (Object obj : serviceList){
            boolean isFather = serviceClass.isAssignableFrom(obj.getClass());
            if (isFather){
                return obj;
            }
        }
        return null;
    }
}
