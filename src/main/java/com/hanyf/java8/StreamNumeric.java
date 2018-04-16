package com.hanyf.java8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author:
 * @Description:
 * @Date: 2018/4/12 19:36
 */
public class StreamNumeric {

    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Stream<Integer> stream2 = stream.filter(integer -> integer.intValue() > 3);
        Integer reduce = stream2.reduce(0, Integer::sum);
        System.out.println(reduce);

        Stream<Integer> stream1 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        IntStream intStream = stream1.mapToInt(i -> i.intValue());
        int sum = intStream.filter(i -> i > 3).sum();
//        intStream.filter(i->i>3).reduce(0,(i,j)->i+j);
        System.out.println(sum);

        //1...100
        //return int[a,b,c]
        int a = 9;
        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .boxed()
                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(r->System.out.println("a="+r[0]+",b="+r[1]+",c="+r[2]));

        IntStream.rangeClosed(1, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                .forEach(r->System.out.println("a="+r[0]+",b="+r[1]+",c="+r[2]));
    }
}
