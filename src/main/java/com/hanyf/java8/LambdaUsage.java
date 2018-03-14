package com.hanyf.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author: hanyf
 * @Description:
 * @Date: Created by in 21:34 2018/3/13
 */
public class LambdaUsage {

    //@FunctionalInterface
    //public interface Adder {
    //    int add(int a, int b);
    //}
    //
    //public interface Empty extends Adder {
    //    int add(long a, long b);
    //}
    //
    //@FunctionalInterface
    //public interface Nothing extends Adder {
    //
    //}

    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {
        ArrayList<Apple> apples = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple)) {
                apples.add(apple);
            }
        }
        return apples;
    }

    private static List<Apple> filterByWeight(List<Apple> source, LongPredicate predicate) {
        ArrayList<Apple> apples = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple.getWeight())) {
                apples.add(apple);
            }
        }
        return apples;
    }

    private static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String, Long> predicate) {
        ArrayList<Apple> apples = new ArrayList<>();
        for (Apple apple : source) {
            if (predicate.test(apple.getColor(), apple.getWeight())) {
                apples.add(apple);
            }
        }
        return apples;
    }

    private static void simpleTestComsumer(List<Apple> source, Consumer<Apple> consumer) {
        for (Apple apple : source) {
            consumer.accept(apple );
        }
    }

    private static void simpleBigConsumer(String c, List<Apple> source, BiConsumer<Apple, String> consumer) {
        for (Apple apple : source) {
            consumer.accept(apple, c);
        }
    }

    private static String testFunction(Apple apple, Function<Apple, String> function) {
        return function.apply(apple);
    }

    private static Apple testBiFunction(String color, long weight, BiFunction<String, Long, Apple> function) {
        return function.apply(color, weight);
    }

    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("Hello");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
        process(r1);
        process(r2);
        process(() -> System.out.println("Hello"));

        List<Apple> list = Arrays.asList(new Apple("green", 120L), new Apple("red", 150l));
        List<Apple> green = filter(list, (apple -> apple.getColor().equals("green")));
        System.out.println(green);

        List<Apple> apples = filterByWeight(list, (w) -> w > 100);
        System.out.println(apples);

        List<Apple> green1 = filterByBiPredicate(list, (s, w) -> s.equals("green") && w > 100);
        System.out.println(green1);

        simpleTestComsumer(list, a -> System.out.println(a));

        simpleBigConsumer("xxx", list, (a, s) -> System.out.println(s + a.getColor() + "Weight=>" + a.getWeight()));

        String yellow = testFunction(new Apple("yellow", 100L), (apple -> apple.toString()));
        System.out.println(yellow);

        IntFunction<Double> f = i -> i * 100.0d;
        Double apply = f.apply(10);
        System.out.println(apply);

        testBiFunction("Blue", 130, (s, w) -> new Apple(s, w));

        Supplier<String> s = String::new;
        System.out.println(s.get().getClass());

        createApple(() -> new Apple("Green", 100L));

        int i = 0;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(i);
            }
        };
    }

    private static void process(Runnable r) {
        r.run();
    }

    private static Apple createApple(Supplier<Apple> supplier) {
        return supplier.get();
    }
}