package com.codingquestions.app.BinarySearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

// import the class that you want to test here
import com.codingquestions.app.BinarySearch.KthClosestInTwoSortedArraies;

public class KthClosestInTwoSortedArraiesTest {

    @BeforeAll
    static void setup() {
    }

    @BeforeEach
    void setupThis() {
    }

    @Test
    void testOne() {
        KthClosestInTwoSortedArraies myClass = new KthClosestInTwoSortedArraies();
        int[] a = new int[] { 1, 4, 5, 5, 8, 12, 12, 12 };
        int[] b = new int[] { 2, 2, 3, 7, 9, 9, 9 };
        int k = 14;
        assertEquals(12, myClass.kthMethodTwo(a, b, k));

    }

    @AfterEach
    void tearThis() {
    }

    @AfterAll
    static void tear() {
    }
}