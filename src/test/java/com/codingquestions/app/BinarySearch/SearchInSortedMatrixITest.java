package com.codingquestions.app.BinarySearch;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import com.codingquestions.app.BinarySearch.SearchInSortedMatrixI;

public class SearchInSortedMatrixITest {

    @BeforeAll
    static void setup() {
    }

    @BeforeEach
    void setupThis() {
    }

    @Test
    void testBaseCase() {
        SearchInSortedMatrixI myClass = new SearchInSortedMatrixI();
        int[][] array = {};
        int[] result = { -1, -1 };
        Assertions.assertTrue(Arrays.equals(myClass.search(array, -1), result));
    }

    @Test
    void testNotFound() {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 7 }, { 8, 9, 10 } };
        SearchInSortedMatrixI myClass = new SearchInSortedMatrixI();
        int[] result = { -1, -1 };
        Assertions.assertTrue(Arrays.equals(myClass.search(matrix, -1), result));
    }

    @Test
    void testFound() {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 7 }, { 8, 9, 10 } };
        SearchInSortedMatrixI myClass = new SearchInSortedMatrixI();
        int[] result = { 0, 0 };
        Assertions.assertTrue(Arrays.equals(myClass.search(matrix, 1), result));
    }

    @AfterEach
    void tearThis() {
    }

    @AfterAll
    static void tear() {
    }
}