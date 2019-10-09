package com.example.maoyanwork.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.*;

/**
 * Location:com.example.maoyanwork.utils
 * Created by zhangpan
 * Date: 2019-05-09
 * Time: 18:16
 * Description:
 */
public class FileUtils {
    public static String getFileContent(String filePath) {// �½������־�ļ�
        File file = new File(filePath);
        StringBuilder sb = new StringBuilder();
        StringBuffer ss = new StringBuffer();
        Map<String,Object> map = new HashMap<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return StringUtils.EMPTY;
    }

    public static void writeLogtoFile(String path, String text) {// �½������־�ļ�
        Date nowtime = new Date();
        String needWriteMessage = nowtime.toGMTString() + " : " + text;
        File file = new File(path);
        try {
            FileWriter filerWriter = new FileWriter(file, true);//����������������ǲ���Ҫ�����ļ���ԭ�������ݣ������и���
            BufferedWriter bufWriter = new BufferedWriter(filerWriter);
            bufWriter.write(needWriteMessage);
            bufWriter.newLine();
            bufWriter.close();
            filerWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File downLoadFile(String httpUrl, String fileName) {
        File tmpFile = new File("/sdcard/update");
        if (!tmpFile.exists()) {
            tmpFile.mkdir();
        }
        final File file = new File("/sdcard/update/" + fileName);
        try {
            URL url = new URL(httpUrl);
            try {
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                InputStream is = conn.getInputStream();
                FileOutputStream fos = new FileOutputStream(file);
                byte[] buf = new byte[256];
                conn.connect();
                if (conn.getResponseCode() >= 400) {
                } else {
                    while (true) {
                        if (is != null) {
                            int numRead = is.read(buf);
                            if (numRead <= 0) {
                                break;
                            } else {
                                fos.write(buf, 0, numRead);
                            }
                        } else {
                            break;
                        }
                    }
                }

                conn.disconnect();
                fos.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return file;
    }
}