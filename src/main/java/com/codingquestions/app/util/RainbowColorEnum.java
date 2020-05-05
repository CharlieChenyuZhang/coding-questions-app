package com.codingquestions.app.util;

// This is an example of how you use ENUM
public enum RainbowColorEnum {
    RED(1, "r"), ORANGE(2, "o");

    public int label;
    public String name;

    private RainbowColorEnum(int label, String name) {
        this.label = label;
        this.name = name;
    };
}

class Test {
    public static void main(String[] args) {

        for (RainbowColorEnum e : RainbowColorEnum.values()) {
            System.out.println(e);
            System.out.println(e.ordinal());
        }

        RainbowColorEnum color1 = RainbowColorEnum.valueOf("RED");
        RainbowColorEnum color2 = RainbowColorEnum.RED;
        System.out.println(color1 == color2);

        System.out.println(color1.label);
        System.out.println(color2.label);
        System.out.println(color1.name);

    }
}