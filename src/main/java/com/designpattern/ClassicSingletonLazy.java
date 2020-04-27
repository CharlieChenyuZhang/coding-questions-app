package com.designpattern;

public class ClassicSingletonLazy {
    private static ClassicSingletonLazy instance = null;
    private String name;

    private ClassicSingletonLazy() {
        this.name = "John";
    }

    public static ClassicSingletonLazy getInstance() {
        if (instance == null) {
            instance = new ClassicSingletonLazy();
        }
        return instance;
    }
}