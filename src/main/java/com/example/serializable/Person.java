package com.example.serializable;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by zhangpan on 2019/2/25.
 * ���Ѷ���ת��Ϊ�ֽ����еĹ��̳�Ϊ��������л���
 �������ֽ����лָ�Ϊ����Ĺ��̳�Ϊ����ķ����л���
 ������������л���Ҫ��������;��
 ����1�� �Ѷ�����ֽ��������õر��浽Ӳ���ϣ�ͨ�������һ���ļ��У�
 ����2�� �������ϴ��Ͷ�����ֽ����С�
 * ��1�� ��ĳЩ���ϣ�ϣ����Ĳ�ͬ�汾�����л����ݣ������Ҫȷ����Ĳ�ͬ�汾������ͬ��serialVersionUID��
 * ��2�� ��ĳЩ���ϣ���ϣ����Ĳ�ͬ�汾�����л����ݣ������Ҫȷ����Ĳ�ͬ�汾���в�ͬ��serialVersionUID��
 */
@Data()
public class Person implements Serializable {
    /**
     * ���л�ID
     */
    private static final long serialVersionUID = -5809782578272943999L;
    private int age;
    private String name;
    private String sex;

}
