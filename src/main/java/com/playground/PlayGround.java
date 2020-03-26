package com.playground;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

class PlayGround {
    public static void main(String[] args) {
        PlayGround s = new PlayGround();
        s = null;

        // Requesting JVM to call Garbage Collector method
        System.gc();
        System.out.println("Main Completes");
    }

    // Here overriding finalize method
    public void finalize() {
        System.out.println("finalize method overriden");
    }
}