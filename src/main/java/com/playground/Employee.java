package com.playground;

import com.playground.Person;

public class Employee extends Person {

    private String company = "Charlie Inc.";

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return this.company;
    }

    public String getName() {
        return getName() + "!";
    }
}