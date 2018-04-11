package com.hanyf.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author:
 * @Description:
 * @Date: 2018/3/26 18:51
 */
public class CreateStream {

    public static void main(String[] args) {
        createStreamFromCollection().forEach(System.out::println);
        createStreamFromValues().forEach(System.out::println);
        createStreamFromArrays().forEach(System.out::println);
    }

    /**
     * @Author: hanyf
     * @Description:
     * @Date: 2018/3/26 18:53
     */
    private static Stream<String> createStreamFromCollection() {
        List<String> strings = Arrays.asList("hello", "alex", "wangwenjun", "world", "stream");
        return strings.stream();
    }

    private static Stream<String> createStreamFromValues() {
        Stream<String> hello = Stream.of("hello", "alex", "wangwenjun", "world", "stream");
        return hello;
    }

    private static Stream<String> createStreamFromArrays() {
        Stream<String> stream = Arrays.stream(new String[]{"hello", "alex", "wangwenjun", "world", "stream"});
        return stream;
    }
}
