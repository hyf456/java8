package com.hanyf.java8;

import lombok.Data;

import java.util.Optional;

/**
 * @Author:
 * @Description:
 * @Date: 2018/4/16 20:48
 */
@Data
public class Car {

    private Optional<Insurance> insurance;
}
