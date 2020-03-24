package com.playground;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public final class PlayGround {
    private int pivotIndex(int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }

    public static void main(String[] args) {

        System.out.println(Math.random());
    }
}
