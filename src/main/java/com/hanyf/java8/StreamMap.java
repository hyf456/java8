package com.hanyf.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Author:
 * @Description:
 * @Date: 2018/4/9 18:40
 */
public class StreamMap {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,6,7,7,1);
        List<Integer> collect = list.stream().map(integer -> integer * 2).collect(toList());
        System.out.println(collect);

        listDish().stream().map(dish -> dish.getName()).forEach(System.out::println);
        List<String> collect1 = listDish().stream().map(dish -> dish.getName()).collect(toList());
        System.out.println(collect1);

        String[] words = {"Hello", "World"};
        //Stream<String[]>    {H,e,l,l,o}{W,o,r,l,d}
        Stream<String[]> stream = Arrays.stream(words).map(w -> w.split(""));
        //H,e,l,l,o,W,o,r,l,d
        Stream<String> stringStream = stream.flatMap(Arrays::stream);
        stringStream.distinct().forEach(System.out::println);

    }

    private static List<Dish> listDish() {
        List<Dish> menu = Arrays.asList(
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
        return menu;
    }
}
