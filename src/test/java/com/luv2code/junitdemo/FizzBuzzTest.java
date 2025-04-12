package com.luv2code.junitdemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    // 1 : If number is divisible by 3, print Fizz

    @Test
    @DisplayName("Divaaaisible by 3")
    @Order(1)
    void testDivisibleByThree(){
        String expected = "Fizz";
        assertEquals(expected, FizzBuzz.compute(3),"Should return Fizz");
    }


    @Test
    @DisplayName("Divisible by 5")
    @Order(2)
    void testDivisibleByFive(){
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.compute(5),"Should return Buzz");
    }

    @Test
    @DisplayName("Divisible by 3 and 5")
    @Order(3)
    void testDivisibleByThreeAndFive(){
        String expected = "FizzBuzz";
        assertEquals(expected,FizzBuzz.compute(15),"Should return FizzBuzz");
    }


    @Test
    @DisplayName("Not Divisible by either 3 or 5")
    @Order(4)
    void testNotDivisibleByThreeFive(){
        String expected = "7";
        assertEquals(expected,FizzBuzz.compute(7),"Should return 7");
    }
}
