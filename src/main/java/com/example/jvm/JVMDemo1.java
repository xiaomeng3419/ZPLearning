package com.example.jvm;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangpan on 2018/12/9.
 * 以 -X 开头的是非标准选项（不能保证被所有的 JVM 实现都支持），如果在后续版本的 JDK 中有变更恕不另行通知。

 Options that are specified with -XX are not stable and are not recommended for casual use. These options are subject to change without notice.
 指定 -XX 的选项是不稳定、不建议随便使用的。这些选项在今后变更恕不另行通知。
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
