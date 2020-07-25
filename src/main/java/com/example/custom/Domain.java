package com.example.custom;

/**
 * Created by zhangpan on 2019/3/3.
 */
public class Domain implements Comparable<Domain>
{
    private String str;

    public Domain(String str)
    {
        this.str = str;
    }

    public int compareTo(Domain domain)
    {
        if (this.str.compareTo(domain.str) > 0)
            return 1;
        else if (this.str.compareTo(domain.str) == 0)
            return 0;
        else
            return -1;
    }
    {
        System.out.println("��ʼ��������������������");
    }
    static  {
        System.out.println("��̬������ʼ����������");
    }

    public String getStr()
    {
        return str;
    }

    /**
     * ������������һ���Ķ���Ƚϣ��Լ����Լ�������Ƚϡ�
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("dsaf");
//        Domain d1 = new Domain("c");
//        Domain d2 = new Domain("c");
//        Domain d3 = new Domain("b");
//        Domain d4 = new Domain("d");
//        System.out.println(d1.compareTo(d2));
//        System.out.println(d1.compareTo(d3));
//        System.out.println(d1.compareTo(d4));
    }

}