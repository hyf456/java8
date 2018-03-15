package com.hanyf.java8;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author: hanyf
 * @Description:
 * @Date: Created by in 21:05 2018/3/13
 */
public class LambdaExpression {

    public static void main(String[] args) {
        Comparator<Apple> byColor = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        List<Apple> list = Collections.emptyList();

        list.sort(byColor);

        Comparator<Apple> byColor2 = (o1, o2) -> o1.getColor().compareTo(o2.getColor());

        Function<String, Integer> flambda = s -> s.length();
        System.out.println(flambda.toString());

        Predicate<Apple> p = (Apple a) -> a.getColor().equals("green");

         Runnable r = () -> {};

         Function<Apple, Boolean> f = (a) -> a.getColor().equals("green");

        Supplier<Apple> supplier = Apple::new;

        Function<Dish, DishTest> dd = (a) -> new DishTest(a.getName(), a.isVegetarian());


    }
}
