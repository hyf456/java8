package com.hanyf.java8;

import lombok.Data;

/**
 * @Author:
 * @Description:
 * @Date: 2018/4/12 20:14
 */
@Data
public class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
}
