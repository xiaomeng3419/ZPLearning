package com.example.jvm;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangpan on 2018/12/9.
 * �� -X ��ͷ���ǷǱ�׼ѡ����ܱ�֤�����е� JVM ʵ�ֶ�֧�֣�������ں����汾�� JDK ���б��ˡ������֪ͨ��

 Options that are specified with -XX are not stable and are not recommended for casual use. These options are subject to change without notice.
 ָ�� -XX ��ѡ���ǲ��ȶ������������ʹ�õġ���Щѡ���ڽ����ˡ������֪ͨ��
 */
public class JVMDemo1 {

//    Reference

    public static void main(String[] args) {
        List<JVMObject > lsit = new ArrayList<>();
        while (true){
            lsit.add(new JVMObject());
        }
    }
}
