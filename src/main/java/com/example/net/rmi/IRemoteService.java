package com.example.net.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by zhangpan on 2019/3/15.
 */
public interface IRemoteService extends Remote {
    String getInfo() throws RemoteException;
}
