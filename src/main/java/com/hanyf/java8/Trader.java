package com.hanyf.java8;

import lombok.Data;

/**
 * @Author:
 * @Description:
 * @Date: 2018/4/12 20:09
 */
@Data
public class Trader {

    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }
}
