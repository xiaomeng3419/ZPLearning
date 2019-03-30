package com.example.net.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

/**
 * Created by zhangpan on 2019/3/15.
 */
public class RemoteServiceTest {
    public static void main(String[] args) throws Exception{
        IRemoteService iRemoteService = new RemoteServiceImpl();
        Context context=new InitialContext();//初始化命名内容
        LocateRegistry.createRegistry(9999);

        context.rebind("rmi://localhost:9999/service1",iRemoteService);
    }
}
