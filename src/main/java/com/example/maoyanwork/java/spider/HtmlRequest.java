package com.example.maoyanwork.java.spider;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Location:com.example.maoyanwork.java.spider
 * Created by zhangpan
 * Date: 2019-05-14
 * Time: 19:00
 * Description:
 */
public class HtmlRequest {
    /** *//**
     * @param args
     * @throws
     */
    public static void main(String[] args) throws Exception    {
        URL url = new URL("http://59.252.101.1:10045/mApp/cinemaFilm?date=2019-05-10&cinemaName=31090701");
        String urlsource = getURLSource(url);
        System.out.println(urlsource);
    }

    /** *//**
     * 通过网站域名URL获取该网站的源码
     * @param url
     * @return String
     * @throws Exception
     */
    public static String getURLSource(URL url) throws Exception    {
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestProperty("content-Type", "application/javascript;charset=UTF-8");
        InputStream inStream =  conn.getInputStream();  //通过输入流获取html二进制数据
        byte[] data = readInputStream(inStream);        //把二进制数据转化为byte字节数据
        String htmlSource = new String(data,"utf-8");
        return htmlSource;
    }

    /** *//**
     * 把二进制流转化为byte字节数组
     * @param instream
     * @return byte[]
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream instream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[]  buffer = new byte[1204];
        int len = 0;
        while ((len = instream.read(buffer)) != -1){
            outStream.write(buffer,0,len);
        }
        instream.close();
        return outStream.toByteArray();
    }

    @Test
    public void charsetTest(){
        System.out.println("专资数据爬取！");
    }

}
