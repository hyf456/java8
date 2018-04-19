package com.hanyf.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @Author:
 * @Description:
 * @Date: 2018/4/16 21:34
 */
public class CollectorsAction {

    public final static List<Dish>  menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    public static void main(String[] args) {
        testAveragingDouble();
        testAveragingInt();
        testAveragingLong();
        testCollectingAndThen();
        testCounting();
        testGroupingByFunction();
        testGroupingByFunctionAndCollector();
        testGroupingByFunctionAndSupplierAndCollector();
        testSummarizingInt();
    }



    private static void testAveragingDouble() {
        System.out.println("testAveragingDouble");
        Double collect = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);

    }

    private static void testAveragingInt() {
        System.out.println("testAveragingInt");
        Double collect = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);

    }

    private static void testAveragingLong() {
        System.out.println("testAveragingLong");
        Double collect = menu.stream().collect(Collectors.averagingLong(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);

    }

    private static void testCollectingAndThen() {
        System.out.println("testCollectingAndThen");
        String collect = menu.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(Dish::getCalories), a -> "The Average Calories is ->" + a));
        Optional.ofNullable(collect).ifPresent(System.out::println);
        //可以对集合修改
        List<Dish> collect1 = menu.stream().filter(d -> d.getType().equals(Dish.Type.MEAT))
                .collect(Collectors.toList());
        collect1.add(new Dish("", false, 100, Dish.Type.OTHER));
        System.out.println(collect1);

        //设置不可以对集合修改
        List<Dish> collect2 = menu.stream().filter(d -> d.getType().equals(Dish.Type.MEAT))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        //这个集合是不可以修改的。
//        collect2.add(new Dish("", false, 100, Dish.Type.OTHER));
    }

    private static void testCounting() {
        System.out.println("testCounting");
        Long collect = menu.stream().collect(Collectors.counting());
        Optional.of(collect).ifPresent(System.out::println);
    }

    private static void testGroupingByFunction() {
        System.out.println("testGroupingByFunction");
        Map<Dish.Type, List<Dish>> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        Optional.of(collect).ifPresent(System.out::println);
    }

    private static void testGroupingByFunctionAndCollector() {
        System.out.println("testGroupingByFunctionAndCollector");
        Map<Dish.Type, Long> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        Optional.of(collect).ifPresent(System.out::println);

        Map<Dish.Type, Double> collect1 = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect1).ifPresent(System.out::println);
    }

    private static void testGroupingByFunctionAndSupplierAndCollector() {
        System.out.println("testGroupingByFunctionAndSupplierAndCollector");
        Map<Dish.Type, Double> collect = menu.stream().collect(Collectors.groupingBy(Dish::getType, TreeMap::new, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(collect.getClass()).ifPresent(System.out::println);
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

    private static void testSummarizingInt() {
        System.out.println("testSummarizingInt");
        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        Optional.ofNullable(collect).ifPresent(System.out::println);
    }

}
