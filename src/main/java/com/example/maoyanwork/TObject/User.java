package com.example.maoyanwork.TObject;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

/**
 * Location:com.example.maoyanwork.TObject
 * Created by zhangpan
 * Date: 2019-05-09
 * Time: 16:24
 * Description:
 */
@Data
public class User {
    public Address address;
    public  User(String address){
        this.address = new Address(address);
    }


    public Optional<User.Address> getAddress() {
        return Optional.ofNullable(address);
    }


    @Data
    @AllArgsConstructor
     public static class Address{
    public Country country;
        public Address(String country){
            this.country = new Country(country);
        }

        public Optional<Country> getCountry() {
            return Optional.ofNullable(country);
        }
    }
    @Data
    @AllArgsConstructor
    public static class  Country{
       public String isocode;


    }

}
