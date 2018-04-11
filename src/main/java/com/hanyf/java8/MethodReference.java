package com.hanyf.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: hanyf
 * @Description:
 * @Date: Created by in 12:24 2018/3/14
 */
public class MethodReference {

    public static void main(String[] args) {
        Consumer<String> consumer = (s -> System.out.println(s));
        useConsumer(consumer, "Hello Alex");

        useConsumer(s -> System.out.println(s), "Hello Alex");

        useConsumer(System.out::println, "Hello Wangwenjun");

        List<Apple> list = Arrays.asList(new Apple("Green", 110L), new Apple("Abc", 123L), new Apple("Red", 123L));
        //升序排列
        list.sort((a1, a2) -> a1.getColor().compareTo(a2.getColor()));
        System.out.println(list);
        //降序排列
        list.sort((a1, a2) -> a2.getColor().compareTo(a1.getColor()));
        System.out.println(list);

        list.stream().forEach(apple -> System.out.println(apple));

        list.stream().forEach(System.out::println);

        int parseInt = Integer.parseInt("123");

        Function<String, Integer> function = Integer::parseInt;

        Integer apply = function.apply("123");
        System.out.println(apply.getClass());
        System.out.println(apply);

        BiFunction<String, Integer, Character> stringIntegerCharacterBiFunction = String::charAt;
        Character hello = stringIntegerCharacterBiFunction.apply("hello", 2);
        System.out.println(hello);

        String hello1 = new String("Hello");
        Function<Integer, Character> integerCharacterFunction = hello1::charAt;
        Character apply1 = integerCharacterFunction.apply(4);
        System.out.println(apply1);

        Supplier<String> supplier = String::new;
        String s = supplier.get();
        System.out.println(s);

        BiFunction<String, Long, Apple> appleBiFunction = Apple::new;
        Apple red = appleBiFunction.apply("red", 100L);
        System.out.println(red);

        ThreeFunction<String, Long ,String, ComplexApple> threeFunction = ComplexApple::new;
        ComplexApple apply2 = threeFunction.apply("Yellow", 100L, "苹果");
        System.out.println(apply2);

        List<Apple> list2 = Arrays.asList(new Apple("Green", 110L), new Apple("Abc", 123L), new Apple("Red", 123L));
        list2.sort(Comparator.comparing(Apple::getColor));
        System.out.println(list2);
        list2.sort(Comparator.comparing(Apple::getColor).reversed());//降序排列
        System.out.println(list2);
    }

    private static <T> void useConsumer(Consumer<T> consumer, T t) {
        consumer.accept(t);
        consumer.accept(t);
    }
}
