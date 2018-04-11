package com.hanyf.java8;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @Author:
 * @Description: filter
 * @Date: 2018/4/9 18:33
 */
public class StreamFilter {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,6,7,7,1);

        List<Integer> collect = list.stream().filter(integer -> integer % 2 == 0).collect(toList());
        System.out.println(collect);
        List<Integer> collect1 = list.stream().distinct().collect(toList());
        System.out.println(collect1);
        List<Integer> collect2 = list.stream().skip(5).collect(toList());
        System.out.println(collect2);
        List<Integer> collect3 = list.stream().limit(5).collect(toList());
        System.out.println(collect3);

    }


}
