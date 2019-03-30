package com.example.custom;

import java.util.Comparator;

/**
 * Created by zhangpan on 2019/3/3.
 */
public class DomainComparator implements Comparator<Domain>
{
    public int compare(Domain domain1, Domain domain2)
    {
        if (domain1.getStr().compareTo(domain2.getStr()) > 0)
            return 1;
        else if (domain1.getStr().compareTo(domain2.getStr()) == 0)
            return 0;
        else
            return -1;
    }

    public static void main(String[] args) {
        Domain d1 = new Domain("c");
        Domain d2 = new Domain("c");
        Domain d3 = new Domain("b");
        Domain d4 = new Domain("d");
        DomainComparator dc = new DomainComparator();
        //两个一样的对象比较。自己与自己不能比较
        System.out.println(dc.compare(d1, d2));
        System.out.println(dc.compare(d1, d3));
        System.out.println(dc.compare(d1, d4));
    }
}