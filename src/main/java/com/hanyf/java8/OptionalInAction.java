package com.hanyf.java8;

import java.util.Optional;

/**
 * @Author:
 * @Description:
 * @Date: 2018/4/16 20:44
 */
public class OptionalInAction {
    public static void main(String[] args) {
        System.out.println(getInsuranceNameByOptional(null));

        Optional.ofNullable(getInsuranceNameByOptional(null)).ifPresent(System.out::print);
    }

    private static String getInsuranceNameByOptional(Person person) {

        Optional<Optional<Car>> car = Optional.ofNullable(person)
                .map(p -> p.getCar());
        return Optional.ofNullable(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName).orElse("Unknown");
    }
}
