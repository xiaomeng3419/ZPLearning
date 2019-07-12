package com.example.maoyanwork.j8.optional;

import com.example.maoyanwork.TObject.Account;
import com.example.maoyanwork.TObject.User;
import org.junit.Test;
//import sun.jvm.hotspot.oops.Oop;

import java.util.Optional;

/**
 * Location:com.example.maoyanwork.j8.optional
 * Created by zhangpan
 * Date: 2019-05-09
 * Time: 16:22
 * Description:
 */

public class OptionalCheck {

    @Test
    public  void whenCreateEmptyOptional_thenNull() {
        Optional<User> emptyOpt = Optional.empty();

    }
    @Test
    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        User user = null;
//        Optional<User> opt = Optional.of(user);
        Optional<User> opt = Optional.ofNullable(user);
//        opt.get();
    }



    @Test
    public void ifSGetElseDefault(){
        Account account = getTestElse();
        System.out.println(account.toString());
    }

    public Account getTestElse(){
        Account account = new Account("zhangsan@maoyan.com");
        Optional<Account> opt1 = Optional.of(account);
        System.out.println(opt1.toString());
        Account s = null;
        System.out.println(opt1.map(u ->u.getEmail()).orElse("wangwu"));
//        System.out.println((int) opt1.orElse(0));
//        return  opt1.orElse(null);
        return Optional.ofNullable(s).orElseGet(() -> new Account("lisi"));
    }

    @Test
    public void when_chain_then_ok(){
        User user = new User("anna@gmail.com");
        String result = Optional.ofNullable(user)
                .flatMap(User :: getAddress)
                .flatMap(User.Address::getCountry)
                .map(User.Country::getIsocode)
                .orElse("lisi");
        System.out.println(result);
    }
}
