package com.example.Date;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zhangpan on 2018/11/8.
 * 关于jdk1.8 新增的date相关类
 * Instant 代替了Date LocalDateTime
 * DateTimeFormatter 代替SimpleDateFormat（线程不安全）
 */
public class JDK18Date {
    private static  final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        }
    };
    public static String TimeStamp2Date(String timestampString, String formats) {
//        if (TextUtils.isEmpty(formats))
            formats = "yyyy-MM-dd HH:mm:ss";
        Long timestamp = Long.parseLong(timestampString)/1000 ;//* 1000;
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        return date;
    }
    public static void main(String[] args) {
        System.out.println(TimeStamp2Date("1553056937621000",""));
        System.out.println(TimeStamp2Date("1553056937623000",""));
  /*      Instant now = Instant.now();
        System.out.println(df.get().format(Date.from(now)));

//        LocalDateTime dateTime = LocalDateTime.parse(new Date(),DATE_FORMATTER);
        //从date到string
        System.out.println(ZoneId.systemDefault().toString());
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        String dataString = DATE_FORMATTER.format(localDateTime);
        System.out.println(dataString);
        //从string到date、
        LocalDateTime stringToDate = LocalDateTime.parse(dataString,DATE_FORMATTER);
        ZoneOffset zoneOffset = OffsetDateTime.now().getOffset();
        Instant instant2 = stringToDate.toInstant(zoneOffset);
        Date date2 = Date.from(instant2);
        System.out.println(date2);*/
    }
}
        