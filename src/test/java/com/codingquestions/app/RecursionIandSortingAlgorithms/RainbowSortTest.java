package com.codingquestions.app.RecursionIandSortingAlgorithms;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

// import the class that you want to test here
import com.codingquestions.app.RecursionIandSortingAlgorithms.RainbowSort;

public class RainbowSortTest {

    @BeforeAll
    static void setup() {
    }

    @BeforeEach
    void setupThis() {
    }

    @Test
    void testOne() {
        RainbowSort myclass = new RainbowSort();
        int[] array = { 1, 0, 1, -1, 0 };
        assertTrue(Arrays.equals(new int[] { -1, 0, 0, 1, 1 }, myclass.rainbowSort(array)));
    }

    @AfterEach
    void tearThis() {
    }

    @AfterAll
    static void tear() {
    }
}