package com.hanyf.java8;

import lombok.Data;

/**
 * @Author: hanyf
 * @Description:
 * @Date: Created by in 20:04 2018/3/13
 */
@Data
public class Apple {
    
     /*
      * 颜色
      */
      private String color;
      
       /*
        * 重量
        */
        private Long weight;

    public Apple() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Apple(String color, Long weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
