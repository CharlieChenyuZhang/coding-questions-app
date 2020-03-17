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
import com.codingquestions.app.BinarySearch.SmallestElementLargerthanTarget;

public class SmallestElementLargerthanTargetTest {

    @BeforeAll
    static void setup() {
    }

    @BeforeEach
    void setupThis() {
    }

    @Test
    void testOne() {
        int[] array = { 4, 13, 14, 19, 20, 21, 30, 31, 32, 36, 40, 41, 41, 50, 55, 58, 61, 66, 78, 82, 92, 93 };
        SmallestElementLargerthanTarget myClass = new SmallestElementLargerthanTarget();

        assertEquals(6, myClass.smallestElementLargerThanTarget(array, 21));
    }

    @AfterEach
    void tearThis() {
    }

    @AfterAll
    static void tear() {
    }
}