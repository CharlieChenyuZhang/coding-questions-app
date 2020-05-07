package com.codingquestions.app.DynamicProgramming;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import com.codingquestions.app.DynamicProgramming.LargestSubArraySumII;

public class LargestSubArraySumIITest {

    @BeforeAll
    static void setup() {
    }

    @BeforeEach
    void setupThis() {
    }

    @Test
    void testOne() {
        LargestSubArraySumII instance = new LargestSubArraySumII();
        assertArrayEquals(new int[] { 3, 2, 2 }, instance.largestSum(new int[] { 1, -2, 3 }));
    }

    @AfterEach
    void tearThis() {
    }

    @AfterAll
    static void tear() {
    }
}