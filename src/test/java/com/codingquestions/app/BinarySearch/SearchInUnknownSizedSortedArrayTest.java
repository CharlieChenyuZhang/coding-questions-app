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
import com.codingquestions.app.BinarySearch.SearchInUnknownSizedSortedArray;
import com.codingquestions.app.utils.MyDict;

public class SearchInUnknownSizedSortedArrayTest {

    @BeforeAll
    static void setup() {
    }

    @BeforeEach
    void setupThis() {
    }

    @Test
    void testOne() {
        SearchInUnknownSizedSortedArray myClass = new SearchInUnknownSizedSortedArray();
        MyDict dict = new MyDict();
        assertEquals(1, myClass.search(dict, 3));
    }

    @AfterEach
    void tearThis() {
    }

    @AfterAll
    static void tear() {
    }
}