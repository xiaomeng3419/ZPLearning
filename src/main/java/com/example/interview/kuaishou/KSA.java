package com.example.interview.kuaishou;

import java.util.Scanner;

/**
 * @Project: ZpBgo
 * @Description：
 * @Author: zhangpan
 * @Creation Date : 2019年09月16日 21:08
 * @ModificationHistory:
 */
public class KSA {

    private static String IPV4 = "IPv4";
    private static String IPV6 = "IPv6";
    private static String neighter = "Neither";

    public static String parse(String line){
        if(line.contains(".")){
            String[] item = line.split("\\.");
            if(item.length == 4 &&parseIpv4(item)){
                return IPV4;
            }
        }
        if(line.contains(":")){
            String[] item = line.split(":");
            if(item.length==8 && parseIpv6(item)){
                return IPV6;
            }
        }
        return neighter;
    }

    public static boolean parseIpv4(String[] item){
        for (int i = 0; i < 4; i++) {
            if (Integer.valueOf(item[i])>255){
                return false;
            }
        }
        if(item[0].length()>1)
            if(!(item[0].charAt(0)>'0'&&item[0].charAt(0)<='9')){
                return false;
            }
        if(item[3].length()>1)
            if(!(item[3].charAt(0)>'0'&&item[3].charAt(0)<='9')){
                return false;
            }
        for (int i = 0; i < item.length; i++) {
            if(item[i].length()>1)
                if(!(item[i].charAt(0)>'0'&&item[i].charAt(0)<='9')){
                    return false;
                }
            for (int j = 1; j <item[i].length() ; j++) {
                if(!(item[i].charAt(j)>='0'&&item[i].charAt(j)<='9')){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean parseIpv6(String[] item){
        for (int i = 0; i < item.length; i++) {
            if (!(item[i].trim().length()>0&&item[i].trim().length()<5)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(parse(line));
    }
}
