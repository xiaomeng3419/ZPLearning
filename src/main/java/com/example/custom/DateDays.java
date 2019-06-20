package com.example.custom;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by zhangpan on 2019/4/14.
 */
public class DateDays {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入年份:");
        int year=scanner.nextInt();
        System.out.println("请输入月份:");
        int month=scanner.nextInt();
        System.out.println("请输入日:");
        int day=scanner.nextInt();
        Calendar calendar=Calendar.getInstance();
        calendar.set(year,month-1,day);
        System.out.println("一年中的第"+calendar.get(Calendar.DAY_OF_YEAR)+"天");
    }
}
