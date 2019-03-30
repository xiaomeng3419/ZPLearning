package com.example.serializable;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by zhangpan on 2019/2/25.
 * 　把对象转换为字节序列的过程称为对象的序列化。
 　　把字节序列恢复为对象的过程称为对象的反序列化。
 　　对象的序列化主要有两种用途：
 　　1） 把对象的字节序列永久地保存到硬盘上，通常存放在一个文件中；
 　　2） 在网络上传送对象的字节序列。
 * 　1、 在某些场合，希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有相同的serialVersionUID；
 * 　2、 在某些场合，不希望类的不同版本对序列化兼容，因此需要确保类的不同版本具有不同的serialVersionUID。
 */
@Data()
public class Person implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -5809782578272943999L;
    private int age;
    private String name;
    private String sex;

}
