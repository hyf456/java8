package com.hanyf.java8;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Author:
 * @Description:
 * @Date: 2018/4/9 19:03
 */
public class StreamFind {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Optional<Integer> any1 = stream.filter(integer -> integer % 2 == 0).findAny();
        System.out.println(any1.get());
        Stream<Integer> stream2 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Optional<Integer> any2 = stream2.filter(integer -> integer < 10).findAny();
//        System.out.println(any2.get());报错
        System.out.println(any2.orElse(-1));
        any2.ifPresent(System.out::print);
        Optional<Integer> integer1 = any2.filter(integer -> integer == 2);
//        Integer integer2 = integer1.get();报错取不到值

        Stream<Integer> stream1 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Optional<Integer> first = stream1.filter(integer -> integer % 2 == 0).findFirst();

        int i = find(new Integer[]{1, 2, 3, 4, 5, 6, 7}, -1, integer -> integer > 100);
        System.out.println(i);
    }

    private static int find(Integer[] values, int defalutValue, Predicate<Integer> predicate) {
        for (int i: values) {
            if(predicate.test(i)) {
                return i;
            }
        }
        return defalutValue;
    }
}
