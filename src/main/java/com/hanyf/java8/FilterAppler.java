package com.hanyf.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: hanyf
 * @Description:
 * @Date: Created by in 20:06 2018/3/13
 */
public class FilterAppler {

    @FunctionalInterface
    public interface AppleFilter {
        boolean filter(Apple apple);
    }

    public static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (appleFilter.filter(apple)) {
                list.add(apple);
            }
        }
        return list;
    }

    public static class GreenAnd160WeightFilter implements AppleFilter {
        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("green") && apple.getWeight() >= 160);
        }
    }

    public static class YellowLessAnd150WeightFilter implements AppleFilter {
        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("yellow") && apple.getWeight() >= 150);
        }
    }



    public static List<Apple> findGreenApple(List<Apple> apples) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    public static List<Apple> findApple(List<Apple> apples, String color) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Apple> list = Arrays.asList(new Apple("green",150L), new Apple("yellow",120L), new Apple("green",170L));
        List<Apple> greenApple = findGreenApple(list);
        assert greenApple.size() == 2;
        List<Apple> green = findApple(list, "green");
        System.out.println(green);

        List<Apple> greenApple1 = findApple(list, "red");
        System.out.println(greenApple1);

        List<Apple> apples = findApple(list, new GreenAnd160WeightFilter());
        System.out.println(apples);

        findApple(list, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return "yellow".equals(apple.getColor());
            }
        });

        List<Apple> lambdaResult = findApple(list, (Apple apple) -> {
            return apple.getColor().equals("green");
        });

        List<Apple> lambdaResult1 = findApple(list, apple -> apple.getColor().equals("green"));

        System.out.println(lambdaResult);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        thread.start();

        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

        Thread.currentThread().join();


    }

}
