package com.designpattern;

public class ClassicSingletonEager {
    private static final ClassicSingletonEager instance = new ClassicSingletonEager();
    private String name;

    private ClassicSingletonEager() {
        this.name = "John";
    }

    public static ClassicSingletonEager getInstance() {
        return instance;
    }
}