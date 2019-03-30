package com.example.net.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by zhangpan on 2019/3/15.
 */
public class RemoteServiceImpl extends UnicastRemoteObject implements IRemoteService {
    private static final long serialVersionUID=1L;
    RemoteServiceImpl() throws RemoteException{

    }
    @Override
    public String getInfo() throws RemoteException {
        return "Get service information success!";
    }
}
