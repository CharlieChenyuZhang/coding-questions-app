package com.playground2;

import com.playground.Employee;

public class Manager extends Employee {
    public Manager() {
    }

    public void xxx() {
        f1();

        // f2();
    }

    public static void main(String[] args) {
        Manager m = new Manager();
        m.xxx();
    }
}
