package com.codingquestions.app.StringII;

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
import com.codingquestions.app.StringII.CompressStringII;

public class CompressStringIITest {

    @BeforeAll
    static void setup() {
    }

    @BeforeEach
    void setupThis() {
    }

    @Test
    void testOne() {
        CompressStringII instance = new CompressStringII();
        assertEquals("a1b1c1", instance.compress("abc"));
    }

    @AfterEach
    void tearThis() {
    }

    @AfterAll
    static void tear() {
    }
}