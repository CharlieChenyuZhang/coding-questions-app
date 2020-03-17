package com.codingquestions.app.utils;

interface Dictionary {
    public Integer get(int index);
}

public class MyDict {
    public MyDict() {
    };

    public Integer get(int index) {
        int[] myArray = { 1, 3 };
        if (index > myArray.length - 1) {
            return null;
        }

        return myArray[index];
    }
}
