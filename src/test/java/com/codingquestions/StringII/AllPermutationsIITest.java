package com.codingquestions.StringII;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

// import the class that you want to test here
import com.codingquestions.app.StringII.AllPermutationsII;

public class AllPermutationsIITest {

    @BeforeAll
    static void setup() {
    }

    @BeforeEach
    void setupThis() {
    }

    @Test
    void testOne() {
        AllPermutationsII instance = new AllPermutationsII();
        List<String> result = new ArrayList<>();
        result.add("");
        assertEquals(result, instance.permutations("    "));
    }

    @AfterEach
    void tearThis() {
    }

    @AfterAll
    static void tear() {
    }
}