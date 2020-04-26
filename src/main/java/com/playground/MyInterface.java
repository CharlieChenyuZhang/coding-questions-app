package com.playground;

public interface MyInterface extends I2, I3 {
    String name = "Charlie Zhang";

    public abstract void getName(); // we don't need to add abastract

}

interface I2 {
    public void test1();
}

interface I3 {
    public void test2();
}