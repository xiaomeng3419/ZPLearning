package com.example.JDWork;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import static com.example.maoyanwork.java.spider.HtmlRequest.readInputStream;

/**
 * @author ：zhangpan
 * @date ：Created in 2019/7/12 17:30
 * @description：
 * @version:
 */
public class DownloadFile {
    private  static String dirPath = "D:\\test\\";
    private static List<String> readTxt(){
        List<String> list = Lists.newArrayList();
        File file=new File("D:\\20190712\\success\\aplicationNo.txt");
        BufferedReader reader=null;
        String temp=null;
        int line=1;
        try{
            reader=new BufferedReader(new FileReader(file));
            while((temp=reader.readLine())!=null){
                list.add(temp);
                System.out.println("line"+line+":"+temp);
                line++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(reader!=null){
                try{
                    reader.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        //创建目录
        if (dir.mkdirs()) {
            System.out.println("创建目录" + destDirName + "成功！");
            return true;
        } else {
            System.out.println("创建目录" + destDirName + "失败！");
            return false;
        }
    }
    public static void jdjrLoadFileDownLoad(String url,String filePath,String fileName)throws Exception{
       /* HttpClient client = HttpClients.createDefault();// 创建默认http连接
        HttpGet post = new HttpGet(url);// 创建一个get请求
        HttpResponse response = client.execute(post);// 用http连接去执行get请求并且获得http响应

        HttpEntity entity = response.getEntity();// 从response中取到响实体
//        String lassName = Downfile.lassName(lujing);
//        boolean createDir = Downfile.createDir(downlujing);
        System.out.println(filePath+fileName);
        File f = new File(filePath+fileName);
        OutputStream out = new FileOutputStream(f);// 如果文件不存在会自动创建
        entity.writeTo(out);
        out.flush();
        out.close();
        System.out.println("下载完成本地完成");*/
        //new一个URL对象
        String cookie ="";
        URL urlT = new URL(url);
//打开链接
        HttpURLConnection conn = (HttpURLConnection)urlT.openConnection();

//设置请求方式为"GET"
        conn.setRequestMethod("GET");
//超时响应时间为5秒
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestProperty("Cookie", cookie);
        conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
//通过输入流获取图片数据
        InputStream inStream = conn.getInputStream();
//得到图片的二进制数据，以二进制封装得到数据，具有通用性
        byte[] data = readInputStream(inStream);
//new一个文件对象用来保存图片，默认保存当前工程根目录
        File imageFile = new File(filePath+fileName);
//创建输出流
        FileOutputStream outStream = new FileOutputStream(imageFile);
//写入数据
        outStream.write(data);
//关闭输出流
        outStream.close();
        System.out.println(url+"  done");
    }

    private static void httpEngine(String resourceID){
       try {
           String IDV = "";
           jdjrLoadFileDownLoad("","","");
        String IDB = "";
           jdjrLoadFileDownLoad("","","");
        String IDl = "";
           jdjrLoadFileDownLoad("","","");
        String IDF = "";
           jdjrLoadFileDownLoad("","","");
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public static void main(String[] args)throws Exception {
        List<String> list = Lists.newArrayList();
        list = readTxt();
        list.forEach(item ->{createDir("D:\\test\\"+item);});
        list.forEach(DownloadFile::httpEngine);
    }
}
