package com.example.javaex.javaex.stream;

import lombok.Data;

/**
 * 苹果类
 */
@Data
public class Apple {
    //重量
    private int weight;
    //颜色
    private String colour;
    // 产地
    private String varieties;

    public Apple(int weight, String colour, String varieties) {
        this.weight = weight;
        this.colour = colour;
        this.varieties = varieties;
    }
}
