package com.hanyf.java8;

/**
 * @Author: hanyf
 * @Description:
 * @Date: Created by in 13:50 2018/3/15
 */
public class DishTest {

    private String name;

    private boolean vegetarian;

    public DishTest(String name, boolean vegetarian) {
        this.name = name;
        this.vegetarian = vegetarian;
    }

    public DishTest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
}
