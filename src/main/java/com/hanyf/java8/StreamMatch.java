package com.hanyf.java8;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author:
 * @Description:
 * @Date: 2018/4/9 18:57
 */
public class StreamMatch {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1,2,3,4,5,6,7});
        boolean b = stream.allMatch(integer -> integer > 10);
        System.out.println(b);
        Stream<Integer> stream1 = Arrays.stream(new Integer[]{1,2,3,4,5,6,7});
        boolean b1 = stream1.anyMatch(integer -> integer > 6);
        System.out.println(b1);
        Stream<Integer> stream2 = Arrays.stream(new Integer[]{1,2,3,4,5,6,7});
        boolean b2 = stream2.noneMatch(integer -> integer < 0);
        System.out.println(b2);
    }
}
