package com.example.JDWork;
import com.alibaba.fastjson.*;
import lombok.Data;

import java.util.Optional;

/**
 * @author ：zhangpan
 * @date ：Created in 2019/7/11 10:32
 * @description：
 * @version:
 */
public class String2Json {
    public static String addItem(String str) {
        JSONObject jsonObject = JSON.parseObject(str);
        String str1 = "\"PPDJDSJ001\"";
        jsonObject.putIfAbsent("applicationNo", Optional.ofNullable(str1).orElseGet(()->{return "zhangpan";}));
        return jsonObject.toJSONString();
    }

    public static void main(String[] args) {
        System.out.println(addItem("{\"code\":\"TR02004\",\"msg\":\"必要文件未上传\",\"tradeNo\":\"TXkmWYbTPxcg9LwZaH20190711T20190711093920217151276\",\"bizContent\":\"\"}"));
        String response = "123";
        try{
            response = "3333";
            System.out.println(response);
        }catch (Exception e){
            System.out.println(response);
        }finally {
            System.out.println(response);
        }
        Persion persion =null;
        System.out.println(Optional.ofNullable(String.valueOf(persion)).orElseGet(()->{return "wlx";}));

    }
}
@Data
class Persion {
    private String name;
    private Integer age;

}