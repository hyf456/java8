package com.hanyf.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Author: hanyf
 * @Description:
 * @Date: Created by in 23:56 2018/3/13
 */
public class SimpleStream {

    public static void main(String[] args) {
        //有一个list (menu)
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
        List<String> dishNamesByCollections = getDishNamesByCollections(menu);
        System.out.println(dishNamesByCollections);

        List<String> dishNamesByStream = getDishNamesByStream(menu);
        System.out.println(dishNamesByStream);
    }

    //stream实现了并行处理 会根据spliterator判断cpu的核数 根据后面true和false判断  ForkJoin是把任务分成几个。
    private static List<String> getDishNamesByStream(List<Dish> menu) {
        Stream<Dish> stream = menu.stream();
        stream.filter(dish -> dish.getCalories() < 400).sorted(Comparator.comparing(d -> d.getCalories())).map(Dish::getName).collect(toList());

        menu.stream().filter(dish -> dish.getCalories() < 400).sorted(Comparator.comparing(dish -> dish.getCalories())).map(Dish::getName).collect(toList());
        menu.stream().filter(dish -> dish.getCalories() < 400).sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).collect(toList());
        return menu.parallelStream().filter(dish -> dish.getCalories() < 400).sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName).collect(toList());
    }

    private static List<String> getDishNamesByCollections(List<Dish> menu) {
        List<Dish> lowCalories = new ArrayList<>();
        //filter and get calories less 400
        for (Dish dish : menu) {
            if (dish.getCalories() < 400)
                lowCalories.add(dish);
        }
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //sort
        Collections.sort(lowCalories, (di1, di2) -> Integer.compare(di1.getCalories(), di2.getCalories()));

        List<String> dishNameList = new ArrayList<>();
        for (Dish dish : lowCalories) {
            dishNameList.add(dish.getName());
        }
        return dishNameList;
    }
}
