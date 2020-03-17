package com.codingquestions.app.BinarySearch;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

// import the class that you want to test here
import com.codingquestions.app.BinarySearch.KClosestInSortedArray;

public class KClosestInSortedArrayTest {

    @BeforeAll
    static void setup() {
    }

    @BeforeEach
    void setupThis() {
    }

    @Test
    void testSolutionOne() {
        int[] array = { 1, 2, 3 };
        KClosestInSortedArray myClass = new KClosestInSortedArray();
        int[] test = myClass.kClosestSolutionOne(array, 2, 3);
        int[] test2 = { 2, 3, 1 };
        System.out.println(Arrays.equals(test, test2));
        Assertions.assertTrue(Arrays.equals(myClass.kClosestSolutionOne(array, 2, 3), new int[] { 2, 3, 1 })
                || Arrays.equals(myClass.kClosestSolutionOne(array, 2, 3), new int[] { 2, 1, 3 }));
    }

    @AfterEach
    void tearThis() {
    }

    @AfterAll
    static void tear() {
    }
}