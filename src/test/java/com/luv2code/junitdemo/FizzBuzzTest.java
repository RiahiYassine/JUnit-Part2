package com.luv2code.junitdemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    // 1 : If the number is divisible by 3, print Fizz
    // 1 : If the number is divisible by 5, print Buzz
    // 1 : If the number is divisible by 3 and 5, print FizzBuzz
    // 1 : If the number isn't divisible by 3 and 5, print the number


    @DisplayName("Divisible by 3")
    @Test
    @Order(1)
    void testDivisibleByThree(){
        String expected = "Fizz";
        assertEquals(expected, FizzBuzz.compute(3),"Should return Fizz");
    }

    @DisplayName("Divisible by 5")
    @Test
    @Order(2)
    void testDivisibleByFive(){
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.compute(5),"Should return Buzz");
    }

    @DisplayName("Divisible by 3 and 5")
    @Test
    @Order(3)
    void testDivisibleByThreeAndFive(){
        String expected = "FizzBuzz";
        assertEquals(expected,FizzBuzz.compute(15),"Should return FizzBuzz");
    }

    @DisplayName("Not Divisible by either 3 or 5")
    @Test
    @Order(4)
    void testNotDivisibleByThreeFive(){
        String expected = "7";
        assertEquals(expected,FizzBuzz.compute(7),"Should return 7");
    }

    @DisplayName("Testing with csv data")
    @ParameterizedTest(name="value={0}, expected={1}")
    @CsvSource({
            "1,1",
            "2,2",
            "3,Fizz",
            "4,4",
            "5,Buzz",
            "6,Fizz",
            "7,7"
    })
    @Order(5)
    void testWithCsvData(int value, String expected){
        assertEquals( expected, FizzBuzz.compute(value),
                () -> String.format("FizzBuzz.compute(%d) should return %s", value, expected));
    }

    @DisplayName("Testing with csv file")
    @ParameterizedTest(name = "[{index}] {arguments}") //  (name="value={0}, expected={1}")
    @CsvFileSource(resources = "/fizzbuzz-test-data.csv", useHeadersInDisplayName = true)
    @Order((6))
    void testWithCsvFileData(int value,String expected){
        assertEquals( expected, FizzBuzz.compute(value),
                () -> String.format("FizzBuzz.compute(%d) should return %s", value, expected));
    }
}
