package com.codingquestions.app.DynamicProgramming;

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
import com.codingquestions.app.DynamicProgramming.LargestSubMatrixSum;

public class LargestSubMatrixSumTest {

    @BeforeAll
    static void setup() {
    }

    @BeforeEach
    void setupThis() {
    }

    @Test
    void testOne() {
        LargestSubMatrixSum instance = new LargestSubMatrixSum();
        assertEquals(1, instance.largest2(new int[][] {

                { 1 }, { -2 } }));
    }

    @AfterEach
    void tearThis() {
    }

    @AfterAll
    static void tear() {
    }
}