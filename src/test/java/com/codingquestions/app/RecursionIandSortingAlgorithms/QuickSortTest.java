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
import com.codingquestions.app.RecursionIandSortingAlgorithms.QuickSort;

public class QuickSortTest {

    @BeforeAll
    static void setup() {
    }

    @BeforeEach
    void setupThis() {
    }

    @Test
    void testOne() {
        int[] array = { 1, 2, 3, 4, 5 };
        QuickSort myclass = new QuickSort();
        assertTrue(Arrays.equals(new int[] { 1, 2, 3, 4, 5 }, myclass.quickSort(array)));
    }

    @AfterEach
    void tearThis() {
    }

    @AfterAll
    static void tear() {
    }
}