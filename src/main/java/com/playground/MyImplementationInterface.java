package com.playground;

import com.playground.MyInterface;

public class MyImplementationInterface implements MyInterface {
    String name;

    public MyImplementationInterface(String name) {
        this.name = name;
    }

    @Override
    public void getName() {
        System.out.println("Your name is " + name);
        System.out.println("Default name is " + MyInterface.name);
    };

    @Override
    public void test1() {
    };

    @Override
    public void test2() {
    };

    public static void main(String[] args) {
        MyImplementationInterface myclass = new MyImplementationInterface("Charlie");
        myclass.getName();
    }
}