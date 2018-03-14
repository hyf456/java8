package com.hanyf.java8;

/**
 * @Author: hanyf
 * @Description:
 * @Date: Created by in 12:54 2018/3/14
 */
public class ComplexApple {

    private String color;

    private Long weigth;

    private String name;

    public ComplexApple(String color, Long weigth, String name) {
        this.color = color;
        this.weigth = weigth;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getWeigth() {
        return weigth;
    }

    public void setWeigth(Long weigth) {
        this.weigth = weigth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ComplexApple{" +
                "color='" + color + '\'' +
                ", weigth=" + weigth +
                ", name='" + name + '\'' +
                '}';
    }
}
