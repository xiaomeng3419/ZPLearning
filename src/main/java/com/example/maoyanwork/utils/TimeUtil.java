package com.example.maoyanwork.utils;

/**
 * Location:com.example.maoyanwork.utils
 * Created by zhangpan
 * Date: 2019-05-22
 * Time: 12:55
 * Description:
 */
import com.example.Thread.aspackage.Run;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TimeUtil   {
    public TimeUtil() {
    }
//    Semaphore
//    Thread
    ConcurrentHashMap<String,Object> map;

    public static String addDay(int subDay) {
        DateTime dateTime = new DateTime();
        DateTime newDate = dateTime.plusDays(subDay);
        return newDate.toString("yyyy-MM-dd");
    }

    public static String getTodayDate() {
        DateTime dateTime = new DateTime();
        return dateTime.toString("yyyy-MM-dd");
    }

    public static String getTodayDateHour() {
        DateTime dateTime = new DateTime();
        return dateTime.toString("yyyy-MM-dd HH:mm:ss");
    }

    public static String getTodayDay() {
        DateTime dateTime = new DateTime();
        return dateTime.toString("yyyyMMdd");
    }

    public static String getTodayDaySecond() {
        DateTime dateTime = new DateTime();
        return dateTime.toString("yyyyMMdd HH:mm:ss");
    }

    public static String getTodayDirectlySecond() {
        DateTime dateTime = new DateTime();
        return dateTime.toString("yyyyMMddHHmmss");
    }

    public static String transformDateToDay(DateTime dateTime) {
        return dateTime.toString("yyyyMMdd");
    }

    public static String transformDateToDay(String dateTimeStr) {
        DateTime dateTime = DateTime.parse(dateTimeStr);
        return dateTime.toString("yyyyMMdd");
    }

    /**
     * 获取当前日期前几天日期。
     * @param todayDay 今天日期
     * @param i   前i天
     * @param format
     * @return
     */
    public static String getHistoryDate(String todayDay ,int i,String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(format);
        DateTime dateTime = DateTime.parse(todayDay, dateTimeFormatter);
        DateTime newDateTime = dateTime.minusDays(i);
        return newDateTime.toString(format);
    }

    @Test
    public  void getHistoryDate(){
//        System.out.println(getTodayDate());
//        System.out.println( getHistoryDate(getTodayDate(),1,"yyyy-MM-dd"));
//        System.out.println( getHistoryDate(getTodayDate(),2,"yyyy-MM-dd"));
        System.out.println(isNumeric("314"));
        System.out.println(isNumeric(""));
        System.out.println(isNumeric("1.2"));
        System.out.println(isNumeric("132s2"));
        System.out.println(isNumeric("222s"));
        System.out.println(isNumeric("--"));
        System.out.println(isNumeric("sss"));
    }




    public static boolean isNumeric(String str){
        if (str.isEmpty()){
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
    @Test
    public void F1Test(){
        System.out.println(3 | 9);
        Integer var = 1;
        System.out.println(var);
        F1(var);
        System.out.println(var);
    }
    public static void F1(Integer var){
        System.out.println(var);
        var = var+1;
        System.out.println(var);
    }

    public static String boxFormat(String num){
        String result = "0";
        try {
            if(num.contains("万")){
                String temp = num.trim().replaceAll("万", "");
                if(isNumber(temp)){
                    BigDecimal box = new BigDecimal(temp);
                    box = box.multiply(new BigDecimal(1000000));
                    return String.valueOf(box.setScale(0));
                }
            }else {
                if(isNumber(num)){
                    BigDecimal box = new BigDecimal(num);
                    box = box.multiply(new BigDecimal(100));
                    return String.valueOf(box.setScale(0));
                }

            }
        }catch (Exception e){
            System.out.println("非数字转0");
        }
        return result;
    }
    public static boolean isNumber(String str){

        Pattern pattern = Pattern.compile("[0-9]*");
        if(str.indexOf(".")>0){//判断是否有小数点
            if(str.indexOf(".")==str.lastIndexOf(".") && str.split("\\.").length==2){ //判断是否只有一个小数点
                return pattern.matcher(str.replace(".","")).matches();
            }else {
                return false;
            }
        }else {
            return pattern.matcher(str).matches();
        }


    }

    @Test
    public void boxFormatTest(){
//        System.out.println( boxFormat("2.1万"));
//        System.out.println(boxFormat("134"));
//        System.out.println(boxFormat("0"));
//        System.out.println(boxFormat("-"));
//        System.out.println(boxFormat("0,2"));
//        System.out.println( boxFormat("2.1万"));
//        System.out.println(boxFormat("134"));
//        System.out.println(boxFormat("0"));
//        System.out.println(boxFormat("-"));
//        System.out.println(boxFormat("0,2"));
//        System.out.println(boxFormat("0.2"));
//        System.out.println(boxFormat("1.2"));
//        System.out.println(boxFormat("02"));
//        System.out.println(String.valueOf(Float.valueOf("1.23") * 100).replaceAll("\\.",""));

//        System.out.println(Integer.valueOf(String.valueOf("0.00").replaceAll("\\.","")));

    }


    public static String removeRateSign(String rate){
        String result = "0";
        if(rate.contains("%")) {
            try {
                result = String.valueOf(Float.valueOf(rate.trim().replaceAll("%", "")) * 100);
            }catch (NumberFormatException e){
                //非数字例如 -- ，"�" （页面上也存在这样的值，例如邢台市）
                System.out.println("非数字转0");
            }
        }
        return result;
    }

    public static String rateFormat(String rate){
        return String.valueOf(Integer.valueOf(rate.trim().replaceAll("%|\\.", "")) );
//        return result;
    }

    @Test
    public  void  rateFormate(){
        System.out.println(rateFormat("33.58%"));
    }



    public static List<String> getDiffDate(String startTime, String endTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        // 声明保存日期集合
        List<String> list = Lists.newArrayList();
        try {
            // 转化成日期类型
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            //用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime()<=endDate.getTime()){
                // 把日期添加到集合
                list.add(sdf.format(startDate));
                // 设置日期
                calendar.setTime(startDate);
                //把日期增加一天
                calendar.add(Calendar.DATE, 1);
                // 获取增加后的日期
                startDate=calendar.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
//            LOGGER.error("ZhuanziBoxController.getDiffDate   error:",e );
        }
        return list;
    }
    public static String  midlineFormat( String date){
        String reg = "(\\d{4})(\\d{2})(\\d{2})";
         date = date.replaceAll(reg, "$1-$2-$3");
         return date;
    }

    @Test
    public  void getDiffDateTest(){
        System.out.println(getDiffDate("20160401","20160501").stream().map(item ->{
            return midlineFormat(item);
        }).collect(Collectors.toList()));

    }
    @Test
    public void midlineFormatTest(){
        System.out.println(midlineFormat("20190520"));
    }



    public static String boxFormat1(String num){
        String result = "0";
        try {
            if(num.contains("万")){
                String temp = num.trim().replaceAll("万", "");
                if(isNumber(temp)){
                    BigDecimal box = new BigDecimal(temp);
                    box = box.multiply(new BigDecimal(1000000));
                    return String.valueOf(box.setScale(0));
                }
            }else {
                if(num.contains(",")){
                    num = num.trim().replaceAll(",", "");
                }
                if(isNumber(num)){
                    BigDecimal box = new BigDecimal(num);
                    box = box.multiply(new BigDecimal(100));
                    return String.valueOf(box.setScale(0));
                }

            }
        }catch (Exception e){
        }
        return result;
    }

    @Test
    public void boxformate2Test(){
//        System.out.println(boxFo rmat1("76"));
//        System.out.println(  2 >> 1 + 1);
        System.out.println(parseMilliSecondToString(Long.valueOf("1559577600000"),"yyyyMMdd"));
    }


    public static String parseMilliSecondToString(long milliSecond, String format) {
        DateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(milliSecond);
    }

}
