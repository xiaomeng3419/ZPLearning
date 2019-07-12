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
        String cookie ="_tp=nxVoWIB1qJC39iRx7uDKTXqoYwn1Bq1QDOkq35eZD%2BY%3D; _pst=zp%E4%BA%AC%E5%8A%A8; __jdu=15620632488541472758435; unpl=V2_ZzNtbUFVREdxABRcK04OAGJURgoRB0VFdg5CUX1LDwZmBkZcclRCFX0UR1JnGF4UZwAZWEFcRxJFCEdkfh1eAmUzIlxyVEMlfThGUHwaXQJlABdUS1NGFXAORVJ%2fEFkHYzMiWnJnGEAbDUFSKElcVWcDEQ8VX3MVcApGU3ocXgZvMxNtQlJKEn0MRFd9HWxOCQJfXUZQQBRyCkVRchBYAGcGFF5EU0oQdwx2VUsa; __jdv=122270672|www.infinitynewtab.com|t_45363_|tuiguang|236c59c9afc44fefba7a27547cb204e0|1562128977437; areaId=1; ipLoc-djd=1-2809-0-0; shshshfpb=i6ZhBClry6fzoOEwFUy16%20g%3D%3D; PCSYCityID=1; shshshfpa=a062228f-37c9-1a1b-0e54-a49d9ecbe1bb-1562128981; shshshfp=f01832faf0ddda741d3097ac35a2ce8a; jd.erp.lang=zh_CN; retina=0; cid=3; webp=1; mba_muid=15620632488541472758435; visitkey=3822702844275227; lessw.jd.com=059474CF3CA6FCB81FA0386D3B44138038FE6993EB6DB0547F128598B35B7CFEDCFDB640AE290167647E95395F38B272DD9D27BEFAFB56D8AF035C305227C5C7; 3AB9D23F7A4B3C9B=2VF2N3EBB5P7WD26VXB6KZSBDOJSEZSFF2BU7JZZWCRXIYSLQU5NTHVLBWHYDKZCFGB234EQDIQ3XVQUUDMADIEE4U; __jdc=142880168; __jda=142880168.15620632488541472758435.1562063249.1562912060.1562917873.19; erp1.jd.com=636EC75C302B0E22D65A204B6098743176E6CD9776197E01A4151306AA62ADFD75E59593078DA43F3AC4D8E0AD6AAD41DA66C589ADA39895C9112DB527C87E3D04623177866A4ACDB44E50F12031AC93; sso.jd.com=BJ.2eb43cfd1e644048ba7867734fcc769c; ___group___=100850; JSESSIONID=89E2678860E4C26C0085A33F9F64E257.s1";

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
           String IDV = "http://oss.jd.com/bucket/loandata/down?objkey=ppd/%s/loanreviewdata/%s_010102_001.jpg";
           jdjrLoadFileDownLoad(String.format(IDV, resourceID,resourceID),dirPath+resourceID+"\\",resourceID+"_010102_001.jpg");
        String IDB = "http://oss.jd.com/bucket/loandata/down?objkey=ppd/%s/loanreviewdata/%s_010103_001.jpg";
           jdjrLoadFileDownLoad(String.format(IDB, resourceID,resourceID),dirPath+resourceID+"\\",resourceID+"_010103_001.jpg");
        String IDl = "http://oss.jd.com/bucket/loandata/down?objkey=ppd/%s/loanreviewdata/%s_010114_001.jpg";
           jdjrLoadFileDownLoad(String.format(IDl, resourceID,resourceID),dirPath+resourceID+"\\",resourceID+"_010114_001.jpg");
        String IDF = "http://oss.jd.com/bucket/loandata/down?objkey=ppd/%s/loanreviewdata/%s_130160_001.pdf";
           jdjrLoadFileDownLoad(String.format(IDF, resourceID,resourceID),dirPath+resourceID+"\\",resourceID+"_130160_001.pdf");
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
