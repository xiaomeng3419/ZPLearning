package com.example.net.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * RMI远程调用步骤：

 1，客户调用客户端辅助对象stub上的方法

 2，客户端辅助对象stub打包调用信息（变量，方法名），通过网络发送给服务端辅助对象skeleton

 3，服务端辅助对象skeleton将客户端辅助对象发送来的信息解包，找出真正被调用的方法以及该方法所在对象

 4，调用真正服务对象上的真正方法，并将结果返回给服务端辅助对象skeleton

 5，服务端辅助对象将结果打包，发送给客户端辅助对象stub

 6，客户端辅助对象将返回值解包，返回给调用者

 7，客户获得返回值
 */

/**
 * Created by zhangpan on 2019/3/15.
 * rmi 的调用过程
 */
public class RmiClientTest {
    public static void main(String[] args) throws Exception{
        Context context = new InitialContext();
        IRemoteService iRemoteService = (IRemoteService)context.lookup("rmi://localhost:9999/service1");
        System.out.println(iRemoteService.getInfo());
    }
}
