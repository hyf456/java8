package com.hanyf.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * @Author:
 * @Description:
 * @Date: 2018/4/12 20:09
 */
public class StreamInAction {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> collect = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(collect);

        transactions.stream().map(t -> t.getTrader().getCity())
                .distinct().forEach(System.out::println);

        transactions.stream().map(Transaction::getTrader)
                .filter(t -> t.getCity().endsWith("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        String reduce = transactions.stream().map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (name1, name2) -> name1 + name2);
        System.out.println(reduce);

        boolean milan = transactions.stream().anyMatch(t -> t.getTrader().getCity().endsWith("Milan"));
        System.out.println(milan);
        boolean milan1 = transactions.stream().map(Transaction::getTrader).anyMatch(t -> t.getCity().equals("Milan"));
        System.out.println(milan1);

        transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        transactions.stream().map(Transaction::getValue)
                .reduce(Integer::max);
        Optional<Integer> reduce1 = transactions.stream().map(Transaction::getValue)
                .reduce((i, j) -> i > j ? i : j);
        System.out.println(reduce1.get());



    }
}
