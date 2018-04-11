package com.hanyf.java8;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author:
 * @Description:
 * @Date: 2018/4/9 19:26
 */
public class StreamReduce {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
//        Integer reduce = stream.reduce(0, (i, j) -> i + j);
        Integer reduce = stream.reduce(0, Integer::sum);
        System.out.println(reduce);

        Stream<Integer> stream1 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream1.reduce((i, j) -> i + j).ifPresent(System.out::println);

        Stream<Integer> stream2 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream2.reduce((i, j) -> i > j ? i : j).ifPresent(System.out::println);
        Stream<Integer> stream3 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        stream3.reduce(Integer::max).ifPresent(System.out::println);
    }
}
