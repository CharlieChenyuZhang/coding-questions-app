package com.playground;

interface MyInterface extends I2, I3 {
    String name = "Charlie Zhang";

    public void getName();

}

interface I2 {
    public void test1();
}

interface I3 {
    public void test2();
}