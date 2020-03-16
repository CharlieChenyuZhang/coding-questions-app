package com.codingquestions.app.BinarySearch;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.codingquestions.app.BinarySearch.ClassicalBinarySearch;

public class ClassicalBinarySearchTest {

  @BeforeAll
  static void setup() {

  }

  @BeforeEach
  void setupThis() {

  }

  @Test
  void testBaseCase() {
    ClassicalBinarySearch myClass = new ClassicalBinarySearch();
    int[] array = {};

    Assertions.assertEquals(-1, myClass.binarySearch(array, -1));
  }

  @Test
  void testOneElementFound() {
    ClassicalBinarySearch myClass = new ClassicalBinarySearch();
    int[] array = { 1 };

    Assertions.assertEquals(-1, myClass.binarySearch(array, -1));
  }

  @Test
  void testOneElementNotFound() {
    ClassicalBinarySearch myClass = new ClassicalBinarySearch();
    int[] array = { 1 };

    Assertions.assertEquals(0, myClass.binarySearch(array, 1));
  }

  @AfterEach
  void tearThis() {

  }

  @AfterAll
  static void tear() {

  }
}