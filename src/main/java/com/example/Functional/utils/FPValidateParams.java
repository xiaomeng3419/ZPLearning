package com.example.Functional.utils;

import com.example.Functional.utils.vo.Request001;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by zhangpan on 2018/11/23.
 *
 * predicate 的作用就是，用来验证的。
 */
public class FPValidateParams {

//  System.out.println(calAll(books , ele->((String)ele).length() > 10));
//    public

    public static void main(String[] args)throws Exception {
        Request001 request001 = new Request001("'zhangpan'",22, Arrays.asList("java","python"));
        List<Request001> l1 = new ArrayList<>();
        l1.add(request001);
        Field[] field02 = Request001.class.getDeclaredFields();
        List<String>  list = new ArrayList<>(field02.length);
        for (Field field : field02){
            list.add(field.getName());
        }

        System.out.println(field02.toString());

        check(Request001.class,request001,l1,ele ->((Request001)ele).getAge()>0,ele ->((Request001)ele).getSkills().size()>0);
    }

  public static <T> boolean check(Class clz,T t, List<Request001> list, Predicate... args) throws Exception{
//      list.forEach(e->);
        boolean flag = true;
        if(list == null && list.isEmpty()){
            return false;
        }
      for (Request001 vo : list){

          for (Predicate arg:args){
              if (!arg.test(vo)){
                 flag = false;break;
              }
          }
          if (!flag)
              break;
      }
        return false;
    }


}
