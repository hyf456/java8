package com.hanyf.java8;

import java.util.Optional;

/**
 * @Author:
 * @Description:
 * @Date: 2018/4/16 19:51
 */
public class OptionalUsage {

    public static void main(String[] args) {
        Optional<Insurance> empty = Optional.<Insurance>empty();
        Optional<Insurance> insuranceOptional = Optional.of(new Insurance());
        /*//Insurance insurance = empty.get();
        Optional<Insurance> insurance1 = Optional.of(new Insurance());
        insurance1.get();

        Optional<Insurance> o = Optional.ofNullable(null);
        o.orElseGet(Insurance::new);
        o.orElse(new Insurance());
        o.orElseThrow(RuntimeException::new);
        o.orElseThrow(()-> new RuntimeException("Not have reference"));
        */
        Optional<String> s = insuranceOptional.map(i -> i.getName());
        System.out.println(s.orElse("empty Value"));
        System.out.println(s.isPresent());
        s.ifPresent(System.out::print);

        System.out.println(getInsuranceName(null));
    }

    private static String getInsuranceName(Insurance insurance) {
        if (null == insurance) {
            return "unknown";
        }
        return insurance.getName();
    }

    private static String getInsuranceNameByOptional(Insurance insurance) {
        return Optional.ofNullable(insurance).map(Insurance::getName).orElse("unknown");
    }
}
