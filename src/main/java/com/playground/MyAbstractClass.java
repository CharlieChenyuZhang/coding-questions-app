package com.playground;

public abstract class MyAbstractClass extends C1 {

    // ... field declarations, constructors
    public static String myName = "Charlie";

    public abstract void play();

    public void printMyName() {
        System.out.println("My name is " + myName);
    }

    // ... concrete methods
}

abstract class C1 {
}

abstract class C2 {
}