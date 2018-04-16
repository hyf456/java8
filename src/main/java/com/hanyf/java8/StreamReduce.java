package com.hanyf.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        int tatal = 6;
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,6,7,7,1);
        Integer reduce1 = list.stream().reduce(tatal, Integer::sum);
        System.out.println(reduce1);


        int sum = 2;

        List<Integer> nums = new ArrayList<Integer>() {{
        add(1);
        add(2);
        }};
        Integer reduce2 = nums.stream().reduce(sum, Integer::sum);
//        nums.stream().forEach(n -> sum +=n);


    }
}
