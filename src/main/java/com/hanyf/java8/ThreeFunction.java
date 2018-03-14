package com.hanyf.java8;

/**
 * @Author: hanyf
 * @Description:
 * @Date: Created by in 12:55 2018/3/14
 */
@FunctionalInterface
public interface ThreeFunction<T,U,K,R> {

    R apply(T t, U u, K k);
}
