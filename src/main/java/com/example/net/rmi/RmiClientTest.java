package com.example.net.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * RMIԶ�̵��ò��裺

 1���ͻ����ÿͻ��˸�������stub�ϵķ���

 2���ͻ��˸�������stub���������Ϣ������������������ͨ�����緢�͸�����˸�������skeleton

 3������˸�������skeleton���ͻ��˸���������������Ϣ������ҳ����������õķ����Լ��÷������ڶ���

 4������������������ϵ���������������������ظ�����˸�������skeleton

 5������˸������󽫽����������͸��ͻ��˸�������stub

 6���ͻ��˸������󽫷���ֵ��������ظ�������

 7���ͻ���÷���ֵ
 */

/**
 * Created by zhangpan on 2019/3/15.
 * rmi �ĵ��ù���
 */
public class RmiClientTest {
    public static void main(String[] args) throws Exception{
        Context context = new InitialContext();
        IRemoteService iRemoteService = (IRemoteService)context.lookup("rmi://localhost:9999/service1");
        System.out.println(iRemoteService.getInfo());
    }
}
